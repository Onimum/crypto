// script.js
function showTab(tabName) {
  // Скрываем все вкладки
  const tabs = document.querySelectorAll('.tab-content');
  tabs.forEach(tab => {
    tab.classList.remove('active');
  });

  // Делаем активной выбранную вкладку
  const tabButtons = document.querySelectorAll('.tab-button');
  tabButtons.forEach(button => {
    button.classList.remove('active');
  });

  // Отображаем соответствующую вкладку
  document.getElementById(tabName).classList.add('active');

  // Активируем кнопку вкладки
  const activeButton = document.querySelector(`.tab-button[onclick="showTab('${tabName}')"]`);
  activeButton.classList.add('active');
}

