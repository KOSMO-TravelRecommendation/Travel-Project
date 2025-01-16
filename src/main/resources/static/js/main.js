document.addEventListener('DOMContentLoaded', function () {
    const apiKey = decodeURIComponent(window.apiKey);
    const apiUrl = 'http://apis.data.go.kr/B551011/KorService1/areaBasedSyncList1';
    const detailApiUrl = 'http://apis.data.go.kr/B551011/KorService1/detailCommon1';
    const container = document.querySelector('.card-section');

	function getRandomAreaCode() {
	    const areaCodes = [1, 2, 3, 4, 5, 6, 7, 8, 31, 32];
	    return areaCodes[Math.floor(Math.random() * areaCodes.length)];
	}

	function getRandomPageNo() {
	    return Math.floor(Math.random() * 5) + 1; // 1부터 5까지 랜덤 값 생성
	}

	async function fetchTravelData() {
	    try {
	        const areaCode = getRandomAreaCode(); // 랜덤 지역 코드 선택

	        // 지역 코드와 지역 이름 매핑
	        const areaCodeMap = {
	            1: "서울",
	            2: "인천",
	            3: "대전",
	            4: "대구",
	            5: "광주",
	            6: "부산",
	            7: "울산",
	            8: "세종시",
	            31: "경기도",
	            32: "강원도"
	        };

	        // Hero Section 업데이트
	        const heroSection = document.querySelector(".hero-section h1");
	        heroSection.textContent = `${areaCodeMap[areaCode]} 관련 관광지들을 추천해드려요!`; // 지역 이름 표시

	        const response = await axios.get(apiUrl, {
	            params: {
	                serviceKey: apiKey,
	                numOfRows: 20, // 20개씩 가져오기
	                pageNo: getRandomPageNo(), // 랜덤 페이지 번호
	                MobileOS: 'ETC',
	                MobileApp: 'Travelpicker',
	                contentTypeId: 12,
	                areaCode: areaCode, // 랜덤 지역 코드
	                showflag: 1,
	                _type: 'Json'
	            },
	        });

	        const items = response?.data?.response?.body?.items?.item;

	        if (!items || items.length === 0) {
	            container.innerHTML = '<p class="text-center">여행지 데이터를 찾을 수 없습니다.</p>';
	            return;
	        }

	        const filteredItems = items.filter(item => item.firstimage); // firstimage가 있는 데이터만 필터링

	        if (filteredItems.length === 0) {
	            container.innerHTML = '<p class="text-center">이미지가 포함된 여행지 데이터를 찾을 수 없습니다.</p>';
	            return;
	        }

	        container.innerHTML = `
	            <div id="travelCarousel" class="carousel slide" data-ride="carousel" data-interval="8000">
	                <div class="carousel-inner">
	                    ${filteredItems.map((item, index) => `
	                        <div class="carousel-item ${index === 0 ? 'active' : ''}">
	                            <div class="d-flex flex-column align-items-center">
	                                <img src="${item.firstimage}" class="d-block travel-image" style="width: 900px; height: 506px; object-fit: cover;" alt="${item.title}" data-contentid="${item.contentid}">
	                                <div class="text-center mt-3">
	                                    <h4>${item.title}</h4>
	                                    <p>${item.addr1 || '주소 정보 없음'}</p>
	                                </div>
	                            </div>
	                        </div>
	                    `).join('')}
	                </div>
	                <a class="carousel-control-prev" href="#travelCarousel" role="button" data-slide="prev">
	                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
	                    <span class="sr-only">Previous</span>
	                </a>
	                <a class="carousel-control-next" href="#travelCarousel" role="button" data-slide="next">
	                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
	                    <span class="sr-only">Next</span>
	                </a>
	            </div>
	        `;

	        document.querySelectorAll('.travel-image').forEach(img => {
	            img.addEventListener('click', async (e) => {
	                const contentId = e.target.getAttribute('data-contentid');
	                await showModal(contentId);
	            });
	        });
	    } catch (error) {
	        console.error('API 호출 중 오류 발생:', error);
	        container.innerHTML = '<p class="text-center text-danger">여행지 데이터를 불러오는 중 오류가 발생했습니다. 나중에 다시 시도해주세요.</p>';
	    }
	}



	async function showModal(contentId) {
	    try {
	        const response = await axios.get(detailApiUrl, {
	            params: {
	                serviceKey: apiKey,
	                _type: 'Json',
	                contentId: contentId,
	                numOfRows: 1,
	                pageNo: 1,
	                MobileOS: 'ETC',
	                MobileApp: 'Travelpicker',
	                defaultYN: 'Y',
	                overviewYN: 'Y'
	            },
	        });

	        // API 응답 디버깅
	        console.log('Detail API Response:', response?.data);

	        // `item`이 배열인 경우 처리
	        const detail = Array.isArray(response?.data?.response?.body?.items?.item)
	            ? response?.data?.response?.body?.items?.item[0]
	            : response?.data?.response?.body?.items?.item;

	        if (!detail) {
	            alert('해당 여행지 정보를 불러올 수 없습니다.');
	            return;
	        }

	        // overview 값 디버깅
	        console.log('Overview:', detail.overview);

	        const overview = detail.overview && detail.overview.trim() !== ''
	            ? detail.overview.replace(/\n/g, '<br>')
	            : '상세 정보가 제공되지 않습니다.';

	        const modal = document.getElementById('infoModal');
	        modal.querySelector('.modal-title').textContent = detail.title || '여행지 정보';
	        modal.querySelector('.modal-body').innerHTML = `
	            <p><strong>소개:</strong> ${overview}</p>
	        `;
	        $('#infoModal').modal('show');
	    } catch (error) {
	        console.error('Modal 데이터 불러오기 오류:', error);
	    }
	}

    fetchTravelData();
});
