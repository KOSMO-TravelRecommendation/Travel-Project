$('#weatherBtn').click(function() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(
            function(position) {
                const latitude = position.coords.latitude;
                const longitude = position.coords.longitude;

                // 날씨 정보를 가져오는 API 호출
                $.get(`/weather?lat=${latitude}&lon=${longitude}`, function(data) {
                    if (data.error) {
                        alert(data.error);
                        return;
                    }

                    const weatherHtml = `
                    <div class="modal fade" id="weatherModal" tabindex="-1" role="dialog">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title">현재 날씨 정보</h5>
                                    <button type="button" class="close" data-dismiss="modal">
                                        <span>&times;</span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <div class="weather-info">
                                        <p><i class="fas fa-calendar"></i> ${data.date}</p>
                                        <p><i class="fas fa-cloud"></i> 날씨: ${data.weather}</p>
                                        <p><i class="fas fa-temperature-high"></i> 현재 기온: ${data.temperature}°C</p>
                                        <p><i class="fas fa-tint"></i> 강수확률: ${data.rainProbability}%</p>
                                        <p><i class="fas fa-map-marker-alt"></i> ${data.location}</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    `;

                    // 기존 날씨 모달 제거 후 새로 추가
                    $('#weatherModal').remove();
                    $('body').append(weatherHtml);
                    $('#weatherModal').modal('show');
                })
                .fail(function(error) {
                    alert('날씨 정보를 가져오는데 실패했습니다.');
                });
            },
            function(error) {
                switch(error.code) {
                    case error.PERMISSION_DENIED:
                        alert("위치 정보 접근을 허용해주세요.");
                        break;
                    case error.POSITION_UNAVAILABLE:
                        alert("위치 정보를 가져올 수 없습니다.");
                        break;
                    case error.TIMEOUT:
                        alert("요청이 시간 초과되었습니다.");
                        break;
                    default:
                        alert("알 수 없는 오류가 발생했습니다.");
                        break;
                }
            }
        );
    } else {
        alert("이 브라우저에서는 위치 정보를 지원하지 않습니다.");
    }
});