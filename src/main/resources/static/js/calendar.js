document.addEventListener('DOMContentLoaded', function() {
    let currentDate = new Date();
    const calendar = {
        init() {
            this.date = currentDate;
            this.render();
            this.bindEvents();
        },

        render() {
            const year = this.date.getFullYear();
            const month = this.date.getMonth();
            
            // Update title
            document.querySelector('.calendar-title').textContent = 
                `${year}년 ${month + 1}월`;
            
            // Clear previous days
            const daysContainer = document.getElementById('calendarDays');
            daysContainer.innerHTML = '';
            
            // Calculate days
            const firstDay = new Date(year, month, 1);
            const lastDay = new Date(year, month + 1, 0);
            const startingDay = firstDay.getDay();
            
            // Previous month's days
            const prevMonthDays = new Date(year, month, 0).getDate();
            for (let i = 0; i < startingDay; i++) {
                const day = document.createElement('div');
                day.className = 'calendar-day other-month';
                day.textContent = prevMonthDays - startingDay + i + 1;
                daysContainer.appendChild(day);
            }
            
            // Current month's days
            const today = new Date();
            for (let i = 1; i <= lastDay.getDate(); i++) {
                const day = document.createElement('div');
                day.className = 'calendar-day';
                if (year === today.getFullYear() && 
                    month === today.getMonth() && 
                    i === today.getDate()) {
                    day.classList.add('today');
                }
                day.textContent = i;
                
                // 주말 색상 추가
                const dayOfWeek = new Date(year, month, i).getDay();
                if (dayOfWeek === 0) { // 일요일
                    day.style.color = '#ff4d4d';
                } else if (dayOfWeek === 6) { // 토요일
                    day.style.color = '#4d79ff';
                }
                
                daysContainer.appendChild(day);
            }
            
            // Next month's days
            const remainingDays = 42 - (startingDay + lastDay.getDate());
            for (let i = 1; i <= remainingDays; i++) {
                const day = document.createElement('div');
                day.className = 'calendar-day other-month';
                day.textContent = i;
                daysContainer.appendChild(day);
            }
        },

        bindEvents() {
            document.getElementById('prevMonth').addEventListener('click', () => {
                this.date.setMonth(this.date.getMonth() - 1);
                this.render();
            });
            
            document.getElementById('nextMonth').addEventListener('click', () => {
                this.date.setMonth(this.date.getMonth() + 1);
                this.render();
            });
        }
    };

    calendar.init();
});