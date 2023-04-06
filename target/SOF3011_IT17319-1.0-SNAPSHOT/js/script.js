const allSideMenu = document.querySelectorAll('#sidebar .side-menu.top li');

allSideMenu.forEach(item => {
  const link = item.querySelector('a');

  link.addEventListener('click', function(event) {
    event.preventDefault();

    // Remove "active" class from all menu items
    allSideMenu.forEach(i => i.classList.remove('active'));

    // Add "active" class to the clicked menu item
    item.classList.add('active');

    // Save active menu to local storage
    localStorage.setItem('activeMenu', item.id);
  });
});

// Add "active" class to the menu item that was active before
const activeMenu = localStorage.getItem('activeMenu');
if (activeMenu) {
  const activeMenuEl = document.getElementById(activeMenu);
  if (activeMenuEl) {
    activeMenuEl.classList.add('active');
  }
}

// document.getElementById(localStorage.getItem('activeMenu')).classList.add('active');

// TOGGLE SIDEBAR
const menuBar = document.querySelector("#content nav .bx.bx-menu");
const sidebar = document.getElementById("sidebar");

menuBar.addEventListener("click", function () {
  sidebar.classList.toggle("hide");
});

const searchButton = document.querySelector(
  "#content nav form .form-input button"
);
const searchButtonIcon = document.querySelector(
  "#content nav form .form-input button .bx"
);
const searchForm = document.querySelector("#content nav form");

searchButton.addEventListener("click", function (e) {
  if (window.innerWidth < 576) {
    e.preventDefault();
    searchForm.classList.toggle("show");
    if (searchForm.classList.contains("show")) {
      searchButtonIcon.classList.replace("bx-search", "bx-x");
    } else {
      searchButtonIcon.classList.replace("bx-x", "bx-search");
    }
  }
});

if (window.innerWidth < 768) {
  sidebar.classList.add("hide");
} else if (window.innerWidth > 576) {
  searchButtonIcon.classList.replace("bx-x", "bx-search");
  searchForm.classList.remove("show");
}

window.addEventListener("resize", function () {
  if (this.innerWidth > 576) {
    searchButtonIcon.classList.replace("bx-x", "bx-search");
    searchForm.classList.remove("show");
  }
});

const switchMode = document.getElementById("switch-mode");

switchMode.addEventListener("change", function () {
  if (this.checked) {
    document.body.classList.add("dark");
  } else {
    document.body.classList.remove("dark");
  }
});

