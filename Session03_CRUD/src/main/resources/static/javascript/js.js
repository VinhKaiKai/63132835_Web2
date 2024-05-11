if ($(".dau").length) {
  function togglemenu() {
    const menuicon = document.querySelector(".menuicon");
    const navbar = document.getElementById("navbar");
    menuicon.classList.toggle("active");
    navbar.classList.toggle("active");
  }

  $(document).ready(function () {
    $(".dau > header > ul > li").click(function () {
      if ($(".menuicon").hasClass("active")) {
        $(".menuicon").removeClass("active");
        $(".dau > header").removeClass("active");
      }
    });
  });
}

if ($(".mod-introduce").length) {
  console.log(123);
  let stars = document.getElementById("stars");
  let moon = document.getElementById("moon");
  let mountains_behind = document.getElementById("mountains_behind");
  let mountains_front = document.getElementById("mountains_front");
  let text = document.getElementById("text");
  // let header = document.querySelector('header');

  window.addEventListener("scroll", function () {
    let value = window.scrollY;
    stars.style.left = value * 0.25 + "px";
    moon.style.top = value * 1.05 + "px";
    mountains_behind.style.top = value * 0.5 + "px";
    mountains_front.style.top = value * 0 + "px";
    text.style.marginRight = value * 4 + "px";
    text.style.marginTop = value * 0.7 + "px";
    header.style.top = value * 0.4 + "px";
  });
}

if ($(".menu").length) {
  //lấy cái bọc chứa các danh sách email để lấy ra 1 mảng danh sách-->
  const slidershow = document.getElementById("slidershow");
  //lấy ra từng cái tag của của từng video
  const slides = slidershow.getElementsByTagName("video");
  //hàm thay đổi đối tượng được chọn trong danh sách-
  var i = 0;
  function nextslide() {
    // hàm next
    slides[i].classList.remove("active");
    i = (i + 1) % slides.length;
    slides[i].classList.add("active");
  }
  function preslide() {
    //hàm lùi
    slides[i].classList.remove("active");
    i = (i - 1 + slides.length) % slides.length;
    slides[i].classList.add("active");
  }

  const slidershowtext = document.getElementById("slidershowtext");
  //lấy ra từng cái tag của của từng video
  const slidestext = slidershowtext.getElementsByTagName("div");
  //<!--hàm thay đổi đối tượng được chọn trong danh sách-->
  var index = 0;
  function nextslidetext() {
    // hàm next
    slidestext[index].classList.remove("active");
    index = (index + 1) % slidestext.length;
    slidestext[index].classList.add("active");
  }
  function preslidetext() {
    //hàm lùi
    slidestext[index].classList.remove("active");
    index = (index - 1 + slidestext.length) % slidestext.length;
    slidestext[index].classList.add("active");
  }

  //ham xử lý các nút khi bấm vào nó sẽ đổi màu
  function thaydoimaunut(type, nutnao) {
    let vinh = document.getElementsByClassName("nut");
    for (index = 0; index < vinh.length; index++) {
      vinh[index].style.background = "rgb(100, 101, 226)";
    }
    nutnao.style.background = "red";
    //ham xử lý thông tin.

    let quan = document.getElementsByClassName("list");
    for (i = 0; i < quan.length; i++) {
      quan[i].style.display = "none";
    }
    document.getElementById(type).style.display = "block";
  }
}
