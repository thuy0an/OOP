// Element
const main = document.querySelector("main");
const body = document.querySelector("body");

// Book

let btnAddToFavoriteList; //=document.querySelector(".book-favorite_btn");
let deletedBook = 0;
// Login , Signup

const inputUsernameSignUp = document.querySelector(".input-username_signup");
const inputPasswordSignup = document.querySelector(".input-password_signup");
const inputEmailSignUp = document.querySelector(".input-email_signup");
const userLogin = document.querySelector(".input-username_login");
const passLogin = document.querySelector(".input-password_login");
const userLogout = document.querySelectorAll(".userLogout");
const fillPassSignup = document.querySelector("#fillpassword");
const btnOpenRegister = document.querySelector(".register-open_btn");
const btnOpenLogin = document.querySelector(".login-open_btn");
const accountBtn = document.querySelectorAll(".accountBtn");
const modalLogin = document.querySelector("#myModalLogin");
const modalRegister = document.querySelector("#myModalRegister");
const closeFormBtn = document.querySelectorAll(".closeForm");

// Menu mobile

const navContainer = document.querySelector(".nav-container");
const mobiMenuBtn = document.querySelector(".mobile-menu-btn");
const navContainerHeight = navContainer.clientHeight;

// Admin

let totalRevenue = 0;
let totalSold = 0;
let statisticRevenueLabel; //=document.querySelector(".statistic-revenue");
let statisticSoldLabel; //=document.querySelector(".statistic-sold");
let btnDeleteUserList; //=document.querySelectorAll(".user-data_button");
let addBookAuthorInput; //=document.querySelector(".add-author_input");
let addBookFileInput; //=document.querySelector(".add-file_input");
let addBookNameInput; //=document.querySelector("add-name_input");
let addBookPriceInput; //=document.querySelector(".add-price_input");
let addBookRatingSelect; //=document.querySelector(".add-rating_select");
let addBookTypeSelect; // = document.querySelector(".add-type_select");
let adminMode = 0;
let btnAddBookConfirm; //= document.querySelector(".btn-add_confirm");
let btnAddClose; //=document.querySelector(".btn-add_close")
let btnAddProduct; //=document.querySelector("btn-manipulate_add")
let btnAdminAccess; //= document.querySelector(".btn-admin_access");
let btnCLoseManipulateDetail; //=document.querySelector(".btn-manipulate_close")
let btnDeleteProductList; //=document.querySelectorAll(".btn-manipulate_delete")
let btnManipulateAdd; //=document.querySelector(".btn-manipulate_add");
let btnManipulateProductList;
let containerStatisticSection; //= document.querySelector(".statistic-section");;
let btnNavigationOrder = document.querySelector(".btn-navigation_order");
let btnNavigationProduct = document.querySelector(".btn-navigation_product");
let btnStatistic; //=document.querySelector("btn-statistic");
let btnNavigationStatistic = document.querySelector(
  ".btn-navigation_statistic"
);
let btnNavigationUser = document.querySelector(".btn-navigation_user");
let btnOrderClose; //=document.querySelector(".btn-order_close");
let btnOrderConfirm; //=document.querySelector(".btn-order_confirm");
let btnOrderDataList; //=document.querySelector(".order-data");
let btnOrderDecline; //=document.querySelector(".btn-order_decline");
let btnSortAmount; //=document.querySelector(".btn-sort_amount");
let btnSortConfirm; //=document.querySelector(".btn-sort_confirm");
let btnSortDecline; //=document.querySelector(".btn-sort_decline");
let btnSortOrder; //=document.querySelector(".btn-sort_order");
let btnSortPending; //=document.querySelector(".btn-sort_pending");
let btnSortUser; //=document.querySelector(".btn-sort_user");
let containerManageOrder; // = document.querySelector(".admin-order_container");
let containerManageStatistic; //= document.querySelector(".admin-statistic_container");
let containerManageUser; // = document.querySelector(".admin-user_container");
let containerMangeProduct; //= document.querySelector(".admin-product_container");
let containerManipulateAdd; //=docuement.querySelector('.manipulate-add_container');
let containerManipulateDetail; //= document.querySelector(".manipulate-detail");
let containerOrderDetail; //=document.querySelector(".order-detail")
let containerOrderSection; //=document.querySelector(".order-section");
let containerUserSection; //=document.querySelectir(".user-section");
let manipulateAddImage;
let inputSortDate; //=document.querySelector("input-sort_date");
// Ultility

const layout = document.querySelector(".layout");
const bookPerPage = 15;
let bookSecionInnerContainer;
let bookSectionOuterContainer;
let btnPaginationList = ""; //=document.querySelectorAll(".btn-pagination");
let btnPaginationNext = ""; //=document.querySelector('.btn-pagination_next);
let btnPaginationPrevious = ""; //=document.querySelector(".btn-pagination-prev");
let currentPage = 0;
let totalPage = 0;
// Onload

createProduct();
checklogin();
headerCartQuantity();
let bookCountArray = new Array();

var userList = [];
createAdmin();
function createAdmin() {
  if (localStorage.getItem("user") === null) {
    let user = {
      username: "admin",
      email: "admin@gmail.com",
      password: "admin",
      id: 1,
      dateSignUp: "11/11/2023",
    };
    userList.push(user);
    localStorage.setItem("user", JSON.stringify(userList));
  }
}

function headerCartQuantity() {
  let cartListArray = JSON.parse(localStorage.getItem("cartCustomer"));
  if (cartListArray) {
    let totalQuantity = cartListArray.reduce(
      (total, item) => total + parseInt(item.quantity),
      0
    );
    document.querySelector(".cart-quantity").textContent = totalQuantity;
  } else document.querySelector(".cart-quantity").textContent = 0;
}

const formatTotal = (number) => {
  const numberString = String(number);
  let result = "";
  for (let i = numberString.length - 1, count = 0; i >= 0; i--, count++) {
    if (count > 0 && count % 3 === 0) {
      result = "." + result;
    }
    result = numberString[i] + result;
  }
  return result;
};

// hàm chỉ dùng 1 lần

function createProduct() {
  if (localStorage.getItem("product") === null) {
    var productArray = [
      {
        name: "Giải thích ngữ pháp tiếng Anh",
        author: "M.L Hương; Abc; Xyz; Gef; Pali; ",
        price: 130000,
        url: "Img/English/img0.jpg",
        rating: 5,
        type: "English",
        id: 0,
      },
      {
        name: "Mind map English",
        author: "Hoàng Ngân",
        price: 109200,
        url: "Img/English/img1.jpg",
        rating: 3,
        type: "English",
        id: 1,
      },
      {
        name: "Destination B1",
        author: "Malcom Mann",
        price: 118000,
        url: "Img/English/img2.jpg",
        rating: 4,
        type: "English",
        id: 2,
      },
      {
        name: "Tự học 2000 từ vựng tiếng Anh",
        author: "Đỗ Nhung",
        price: 42250,
        url: "Img/English/img3.jpg",
        rating: 4,
        type: "English",
        id: 3,
      },
      {
        name: "IELTS ACADEMIC 18",
        author: "Cambridge",
        price: 195000,
        url: "Img/English/img4.jpg",
        rating: 5,
        type: "English",
        id: 4,
      },
      {
        name: "Thì và sự phối hợp thì tron tiếng Anh",
        author: "M.L Hương",
        price: 51100,
        url: "Img/English/img5.jpg",
        rating: 4,
        type: "English",
        id: 5,
      },
      {
        name: "Tiếng Anh 3",
        author: "Võ Đại Phúc",
        price: 60800,
        url: "Img/English/img6.jpg",
        rating: 4,
        type: "English",
        id: 6,
      },
      {
        name: "Expression for English speaking",
        author: "Siwon Lee",
        price: 103000,
        url: "Img/English/img7.jpg",
        rating: 3,
        type: "English",
        id: 7,
      },
      {
        name: "Động từ bất quy tắc & ngữ pháp tiếng Anh căn bản",
        author: "M.L Hương",
        price: 45000,
        url: "Img/English/img8.jpg",
        rating: 5,
        type: "English",
        id: 8,
      },
      {
        name: "Chiến tranh tiền tệ",
        author: "Song Hong Bin",
        price: 103200,
        url: "Img/Finance/img0.jpg",
        rating: 3,
        type: "Finance",
        id: 9,
      },
      {
        name: "Làm chủ Business Analytics",
        author: "Trần Hùng Thiện & Tăng Thúy Nga",
        price: 228650,
        url: "Img/Finance/img1.jpg",
        rating: 2,
        type: "Finance",
        id: 10,
      },
      {
        name: "Doanh nghiệp của thế kỷ 21",
        author: "Robert T.Kiyosaki",
        price: 84000,
        url: "Img/Finance/img2.jpg",
        rating: 4,
        type: "Finance",
        id: 11,
      },
      {
        name: "Các cuộc chién tranh tiền tệ",
        author: "James Rickards",
        price: 144000,
        url: "Img/Finance/img3.jpg",
        rating: 4,
        type: "Finance",
        id: 12,
      },
      {
        name: "Kinh tế học thời khó nhọc",
        author: "Abhijit V. Banerjee",
        price: 175000,
        url: "Img/Finance/img4.jpg",
        rating: 4,
        type: "Finance",
        id: 13,
      },
      {
        name: "Tiền đấu với vàng ",
        author: "James Rickards",
        price: 123500,
        url: "Img/Finance/img5.jpg",
        rating: 2,
        type: "Finance",
        id: 14,
      },
      {
        name: "Những đối thủ Châu Á",
        author: "Philip Kotler",
        price: 184500,
        url: "Img/Finance/img6.jpg",
        rating: 3,
        type: "Finance",
        id: 15,
      },
      {
        name: "Tinh hoa kinh tế học",
        author: "Paul Krugman",
        price: 412000,
        url: "Img/Finance/img7.jpg",
        rating: 4,
        type: "Finance",
        id: 16,
      },
      {
        name: "Mã Gen cải cách",
        author: "Jeff Dyer Halgregersen",
        price: 111200,
        url: "Img/Finance/img8.jpg",
        rating: 3,
        type: "Finance",
        id: 17,
      },
      {
        name: "Economix",
        author: "Michael Goodwin",
        price: 98800,
        url: "Img/Finance/img9.jpg",
        rating: 2,
        type: "Finance",
        id: 18,
      },
      {
        name: "Tự học viết tiếng Nhật căn bản Hiragana",
        author: "Jim Gleeson",
        price: 37000,
        url: "Img/Japanese/img0.jpg",
        rating: 2,
        type: "Japanese",
        id: 19,
      },
      {
        name: "2000 từ vựng dành cho kỳ thi năng lưc Nhật ngữ N3",
        author: "Arc Academy",
        price: 75200,
        url: "Img/Japanese/img1.jpg",
        rating: 3,
        type: "Japanese",
        id: 20,
      },
      {
        name: "Tiếng Nhật công nghệ thông tin",
        author: "Komaki Michiko",
        price: 213000,
        url: "Img/Japanese/img2.jpg",
        rating: 1,
        type: "Japanese",
        id: 21,
      },
      {
        name: "Luyện thi Nhật ngữ N2",
        author: "Sasaki Hikoto",
        price: 64000,
        url: "Img/Japanese/img3.jpg",
        rating: 4,
        type: "Japanese",
        id: 22,
      },
      {
        name: "Sổ tay tiếng Nhật thương mại",
        author: "Maki Okumura",
        price: 68000,
        url: "Img/Japanese/img4.jpg",
        rating: 2,
        type: "Japanese",
        id: 23,
      },
      {
        name: "Giáo trình luyện thi Nhật ngữ N3 TRY!",
        author: "Hiệp Hội Văn Hóa Sinh Viên Châu Á",
        price: 53000,
        url: "Img/Japanese/img5.jpg",
        rating: 5,
        type: "Japanese",
        id: 24,
      },
      {
        name: "Ngôn ngữ và văn hóa Nhật Bản",
        author: "Uzumaki Naruto",
        price: 149000,
        url: "Img/Japanese/img6.jpg",
        rating: 2,
        type: "Japanese",
        id: 25,
      },
      {
        name: "Mind Map tiếng Nhật",
        author: "Trà My",
        price: 207000,
        url: "Img/Japanese/img7.jpg",
        rating: 4,
        type: "Japanese",
        id: 26,
      },
      {
        name: "Bộ đề luyện thi năng lực Nhật ngữ N5",
        author: "ASK",
        price: 115000,
        url: "Img/Japanese/img8.jpg",
        rating: 5,
        type: "Japanese",
        id: 27,
      },
      {
        name: "Giáo trình chuẩn HSK 1",
        author: "Khương Lệ Bình",
        price: 147000,
        url: "Img/Chinese/img0.jpg",
        rating: 5,
        type: "Chinese",
        id: 28,
      },
      {
        name: "Giáo trình Hán Ngữ",
        author: "Đại học ngôn ngữ Bắc Kinh",
        price: 170800,
        url: "Img/Chinese/img1.jpg",
        rating: 5,
        type: "Chinese",
        id: 29,
      },
      {
        name: "Giáo trình chuẩn YCT",
        author: "Tô Anh Hà",
        price: 148000,
        url: "Img/Chinese/img2.jpg",
        rating: 1,
        type: "Chinese",
        id: 30,
      },
      {
        name: "Giáo trình Hán ngữ",
        author: "Trương Văn Giới ",
        price: 85000,
        url: "Img/Chinese/img3.jpg",
        rating: 3,
        type: "Chinese",
        id: 31,
      },
      {
        name: "Giáo trình Hán ngữ Boya",
        author: "Lý Hiểu Kỳ",
        price: 97000,
        url: "Img/Chinese/img4.jpg",
        rating: 3,
        type: "Chinese",
        id: 32,
      },
      {
        name: "Tập viết chữ Hán",
        author: "McBooks",
        price: 58500,
        url: "Img/Chinese/img5.jpg",
        rating: 4,
        type: "Chinese",
        id: 33,
      },
      {
        name: "Luyện viết chữ Hán",
        author: "Nguyễn Phước Lộc",
        price: 129000,
        url: "Img/Chinese/img6.jpg",
        rating: 5,
        type: "Chinese",
        id: 34,
      },
      {
        name: "3000 câu giao tiếp Hoa Việt",
        author: "Nguyễn Thiện Chí",
        price: 69400,
        url: "Img/Chinese/img7.jpg",
        rating: 2,
        type: "Chinese",
        id: 35,
      },
      {
        name: "MindMap từ vựng tiếng Trung theo giáo trình Hán Ngữ",
        author: "Hoàng Minh Hồng",
        price: 165350,
        url: "Img/Chinese/img8.jpg",
        rating: 1,
        type: "Chinese",
        id: 36,
      },
      {
        name: "Bluelock",
        author: "Muneshiro Kanesaki",
        price: 45000,
        url: "Img/Manga/img0.png",
        rating: 5,
        type: "Manga",
        id: 37,
      },
      {
        name: "Moriaty The Patriot",
        author: "Ryosuke Takeuchi ",
        price: 42750,
        url: "Img/Manga/img1.jpg",
        rating: 5,
        type: "Manga",
        id: 38,
      },
      {
        name: "Oshi No Ko",
        author: "Aka Akasaka",
        price: 54000,
        url: "Img/Manga/img2.jpg",
        rating: 4,
        type: "Manga",
        id: 39,
      },
      {
        name: "Kaguya-sama Love is war",
        author: "Aka Asaka",
        price: 58000,
        url: "Img/Manga/img3.jpg",
        rating: 5,
        type: "Manga",
        id: 40,
      },
      {
        name: "Spy X Family",
        author: "Tatsuya Endo",
        price: 42000,
        url: "Img/Manga/img4.jpg",
        rating: 5,
        type: "Manga",
        id: 41,
      },
      {
        name: "Solo Leveling",
        author: "Chugong",
        price: 78880,
        url: "Img/Manga/img5.jpg",
        rating: 5,
        type: "Manga",
        id: 42,
      },
      {
        name: "One Punch Man",
        author: "Yusuke Murata",
        price: 23000,
        url: "Img/Manga/img6.jpg",
        rating: 5,
        type: "Manga",
        id: 43,
      },
      {
        name: "Thay đổi cuộc sống với Nhân số học",
        author: "Lê Đỗ Quỳnh Hương",
        price: 171000,
        url: "Img/Psychology/img0.png",
        rating: 3,
        type: "Psychology",
        id: 44,
      },
      {
        name: "Dám nghĩ lại",
        author: "Adam Grant",
        price: 116000,
        url: "Img/Psychology/img1.png",
        rating: 4,
        type: "Psychology",
        id: 45,
      },
      {
        name: "Hiểu về trái tim",
        author: "Minh Niệm",
        price: 124000,
        url: "Img/Psychology/img2.jpg",
        rating: 2,
        type: "Psychology",
        id: 46,
      },
      {
        name: "Nóng giận là bản năng tĩnh lặng là bản lĩnh",
        author: "Tống mặc",
        price: 55340,
        url: "Img/Psychology/img3.png",
        rating: 5,
        type: "Psychology",
        id: 47,
      },
      {
        name: "Atomic Habits",
        author: "James Clear",
        price: 186000,
        url: "Img/Psychology/img4.jpg",
        rating: 4,
        type: "Psychology",
        id: 48,
      },
      {
        name: "Tiền không mua được gì ",
        author: "Michael Sandel",
        price: 98100,
        url: "Img/Psychology/img5.jpg",
        rating: 3,
        type: "Psychology",
        id: 49,
      },
      {
        name: "Sức mạnh tiềm thức",
        author: "Dr.Joseph Murphy",
        price: 88100,
        url: "Img/Psychology/img6.jpg",
        rating: 4,
        type: "Psychology",
        id: 50,
      },
    ];
    localStorage.setItem("product", JSON.stringify(productArray));
  }
}

createOrderTemp();
function createOrderTemp(){
  if ( localStorage.getItem("orderCustomer")==null)
  {
    let OrderArray=JSON.parse(localStorage.getItem("orderCustomer"));
    console.log(OrderArray);
    let OrderArrayList= [
      {
        id: 0, 
        name: 'orderTest1', 
        phone:'28112023', 
        address:'abc Q6 THPCM',
        dateOrder: "28/11/2023", 
        accCustomer: {username: "orderTest1", password: "orderTest1", id:3, email:"orderTest1@gmail.com", dateSignUp:"28/11/2023"},
        bookArr: [
          {name:"Mind map English",price:109200, url:"img/English/img1.jpg", quantity:"5", type:"English", id:1},
          {name:"Tự học 2000 từ vựng tiếng Anh",price:42250, url:"img/English/img3.jpg", quantity:"5", type:"English", id:3}
        ],
        orderBook: "4 x Tự học 2000 từ vựng tiếng Anh; 5 x Mind map English; ",
        totalPrice: 715000,
        status: 1,
      },
      {
        id: 1, 
        name: 'orderTest2', 
        phone:'28112023', 
        address:'abc Ba Dinh HaNoi', 
        dateOrder: "20/11/2023", 
        accCustomer: {username: "orderTest2", password: "orderTest2", id:4, email:"orderTest2@gmail.com", dateSignUp:"28/11/2023"},
        bookArr: [
          {name:"Luyện thi Nhật ngữ N2",price:64000, url:"img/Japanese/img3.jpg", quantity:"6", type:"Japanese", id:22},
          {name:"MindMap từ vựng tiếng Trung theo giáo trình Hán Ngữ",price:165350, url:"img/Chinese/img8.jpg", quantity:"3", type:"Chinese", id:36},
          { name:"Kaguya-sama Love is war",price:58000, url:"img/Manga/img3.jpg", quantity:"2", type:"Manga", id:40},
        ],
        orderBook: "6 x Luyện thi Nhật ngữ N2; 3 x MindMap từ vựng tiếng Trung theo giáo trình Hán Ngữ; 2 x Kaguya-sama Love is war;",
        totalPrice: 996050,
        status: 0,
      },
      {
        id: 2, 
        name: 'orderTest3', 
        phone:'28112023',
        dateOrder: "31/11/2023",  
        address:'abc', 
        accCustomer: {username: "orderTest3", password: "orderTest3", id:5, email:"orderTest3@gmail.com", dateSignUp:"28/11/2023"},
        bookArr: [
          {name:"Sức mạnh tiềm thức",price:88100, url:"img/Psychology/img6.jpg", quantity:"4", type:"Psychology", id:50},
          {name:"Tiền không mua được gì ",price:98100, url:"img/Psychology/img5.jpg", quantity:"3", type:"Psychology", id:49},
          {name:"Solo Leveling",price:78880, url:"img/Manga/img5.jpg", quantity:"1", type:"Manga", id:42},
          {name:"Bộ đề luyện thi năng lực Nhật ngữ N5",price:115000, url:"img/Japanese/img8.jpg", quantity:"2", type:"Japanese", id:27},
          {name:"Tinh hoa kinh tế học",price:412000, url:"img/Finance/img7.jpg", quantity:"2", type:"Finance", id:16},
        ],
        orderBook: "4 x Sức mạnh tiềm thức; 3 x Tiền không mua được gì; 1 x SoLo Leveling; 2 x Bộ đề luyện thi năng lực Nhật ngữ N5; 2 x Tinh hoa kinh tế học",
totalPrice: 1037980,
        status: 1,
      },
      {
        id: 3, 
        name: 'orderTest4', 
        phone:'28112023',
        dateOrder: "24/2/2023",  
        address:'abc Ca Mau', 
        accCustomer: {username: "orderTest4", password: "orderTest4", id:6, email:"orderTest4@gmail.com", dateSignUp:"28/11/2023"},
        bookArr: [
          { name:"Chiến tranh tiền tệ",price:103200, url:"img/Finance/img0.jpg", quantity:"3", type:"Finance", id:9},
          { name:"Làm chủ Business Analytics",price:228650, url:"img/Finance/img1.jpg", quantity:"2", type:"Finance", id:10},
          { name:"Tập viết chữ Hán",price:58500, url:"img/Chinese/img5.jpg", quantity:"2", type:"Chinese", id:33},
          { name:"Thì và sự phối hợp thì tron tiếng Anh",price:51100, url:"img/English/img5.jpg", quantity:"1", type:"English", id:5},
        ],
        orderBook: "3 x Chiến tranh tiền tệ ; 2 x Làm chủ Business Analytics; 2 x Tập viết chữ Hán; 1 x Thì và sự phối hợp thì tron tiếng Anh;",
        totalPrice: 935000,
        status: 0,
      },
      {
        id: 4, 
        name: 'orderTest5', 
        phone:'28112023',
        dateOrder: "29/6/2023",  
        address:'abc Q12 TpHCM', 
        accCustomer: {username: "orderTest5", password: "orderTest5", id:7, email:"orderTest5@gmail.com", dateSignUp:"28/11/2023"},
        bookArr: [
          { name:"IELTS ACADEMIC 18",price:195000, url:"img/English/img4.jpg", quantity:"5", type:"English", id:4},
          { name:"Những đối thủ Châu Á",price:184500, url:"img/Finance/img6.jpg", quantity:"5", type:"Finance", id:15},
          { name:"Giáo trình Hán Ngữ",price:170800, url:"img/Chinese/img1.jpg", quantity:"5", type:"Chinese", id:29},
          { name:"3000 câu giao tiếp Hoa Việt",price:69400, url:"img/Chinese/img7.jpg", quantity:"5", type:"Chinese", id:35},
          { name:"Oshi No Ko",price:54000, url:"img/Manga/img2.jpg", quantity:"5", type:"Manga", id:39},
          { name:"Nóng giận là bản năng tĩnh lặng là bản lĩnh",price:55340, url:"img/Psychology/img3.png", quantity:"5", type:"Psychology", id:47},
        ],
        orderBook: "5 x IELTS ACADEMIC 18; 5 x Những đối thủ Châu Á; 5 x Giáo trình Hán Ngữ; 5 x 3000 câu giao tiếp Hoa Việt; 5 x Oshi No Ko; 5 x Nóng giận là bản năng tĩnh lặng là bản lĩnh",
        totalPrice: 3645200,
        status: 0,
      },

    ];
    localStorage.setItem("orderCustomer",JSON.stringify(OrderArrayList));
  }
}

// Reset Page
 document.addEventListener("click", () => {
   let logoBtn = document.querySelector(".header-utility_logo");
   logoBtn.addEventListener("click", () => {
     window.location.reload();
   });

   let mainPage = document.querySelector(".main-page");
   mainPage.addEventListener("click", () => {
     window.location.reload();
   });
 });

// Menu Header responsive

mobiMenuBtn.addEventListener("click", () => {
  let isClose = navContainer.clientHeight === navContainerHeight;
  if (isClose) navContainer.style.height = "auto";
  else navContainer.style.height = null;
});

// Slider function
const sliderTrack = document.querySelector(".slider-track"); //Lay ra container chua anh
const sliderItem = Array.from(sliderTrack.children); //Lay ra cac phan tu co trogn container -> 5 li img
const btnSliderNext = document.querySelector(".slider-button_next");
const btnSliderPrevious = document.querySelector(".slider-button_previous");
const indicatorNav = document.querySelector(".slider-nav");
const indicatorList = Array.from(indicatorNav.children); //Lay ra cac indicator
const slideSize = sliderItem[0].getBoundingClientRect().width; //Lay ra width cua container hay anh co width =100% container
const currentSLiderIndicator = indicatorList[0];
const setSliderPosition = () => {
  sliderItem.forEach((item, index) => {
    item.style.left = index * slideSize + "px";
  });
};
setSliderPosition();

const moveSlide = (currentSlide, targetSlide) => {
  sliderTrack.style.transform = "translateX(-" + targetSlide.style.left + ")";
  currentSlide.classList.remove("current-slide");
  targetSlide.classList.add("current-slide");
};
const moveIndicators = (currentIndicator, targetIndicator) => {
  currentIndicator.classList.remove("current-indicator");
  targetIndicator.classList.add("current-indicator");
};
btnSliderPrevious.addEventListener("click", () => {
  const currentSlide = sliderTrack.querySelector(".current-slide");
  const currentIndicator = indicatorNav.querySelector(".current-indicator");
  if (currentSlide == sliderItem[0]) {
    const prevSlide = sliderItem[sliderItem.length - 1];
    const prevIndicator = indicatorList[indicatorList.length - 1];
    moveSlide(currentSlide, prevSlide);
    moveIndicators(currentIndicator, prevIndicator);
  } else {
    const prevSlide = currentSlide.previousElementSibling;
    const prevIndicator = currentIndicator.previousElementSibling;
    moveSlide(currentSlide, prevSlide);
    moveIndicators(currentIndicator, prevIndicator);
  }
  clearInterval(intervalId);
  intervalId = setInterval(moveRight, 2500);
});
const moveRight = () => {
  const currentSlide = sliderTrack.querySelector(".current-slide");
  const currentIndicator = indicatorNav.querySelector(".current-indicator");
  if (currentSlide == sliderItem[sliderItem.length - 1]) {
    const nextSlide = sliderItem[0];
    const nextIndicator = indicatorList[0];
    moveSlide(currentSlide, nextSlide);
    moveIndicators(currentIndicator, nextIndicator);
  } else {
    const nextSlide = currentSlide.nextElementSibling;
    const nextIndicator = currentIndicator.nextElementSibling;
    moveSlide(currentSlide, nextSlide);
    moveIndicators(currentIndicator, nextIndicator);
  }
  clearInterval(intervalId);
  intervalId = setInterval(moveRight, 2500);
};
btnSliderNext.addEventListener("click", moveRight);
indicatorList.forEach((indicator) => {
  indicator.addEventListener("click", () => {
    const targetSlide =
      sliderItem[indicator.getAttribute("id").split("-")[1] - 1];
    const currentSlide = sliderTrack.querySelector(".current-slide");
    const currentIndicator = indicatorNav.querySelector(".current-indicator");
    moveSlide(currentSlide, targetSlide);
    moveIndicators(currentIndicator, indicator);
    clearInterval(intervalId);
    intervalId = setInterval(moveRight, 2500);
  });
});
let intervalId = setInterval(moveRight, 2500);

// //
// let active = 0;
// const sliderItemsSize = sliderItems.length - 1;
// let refreshSlider = setInterval(() => {next.click();}, 4000);
// const reloadSlider = () => {
//   let checkLeft = sliderItems[active].offsetLeft;
//   sliderList.style.left = -checkLeft + "px";

//   let lastActiveDot = document.querySelector(".slider-dots li.active");

//   lastActiveDot.classList.remove("active");
//   dots[active].classList.add("active");

//   clearInterval(refreshSlider);
//   refreshSlider = setInterval(() => { next.click();}, 4000);
// };

// dots.forEach((li, index) => {
//   li.addEventListener("click", function () {
//     active = index;
//     reloadSlider();
//   });
// });

// nextSliderBtn.addEventListener("click", () => {
//   if (active + 1 > sliderItemsSize)
//     active = 0;
//   else
//     active++;
//   reloadSlider();
// });
// prevSliderBtn.addEventListener("click", () => {

//   if (active - 1 < 0)
//     active = sliderItemsSize;
//   else active--;
//   reloadSlider();
// });

// JS for searchbar
// Populate the list with products

document.querySelector(".header-search_input").addEventListener("keyup", () => {
  let input = document.querySelector(".header-search_input");
  let filter = input.value.toUpperCase();
  let ul = document.querySelector(".myUL");
  let li = ul.getElementsByTagName("li");
  if (input.value.length > 0) ul.style.display = "block";
  else ul.style.display = "none";
  for (let i = 0; i < li.length; i++) {
    let txtValue = li[i].textContent || li[i].innerText;
    if (txtValue.toUpperCase().indexOf(filter) > -1) li[i].style.display = "";
    else li[i].style.display = "none";
  }
});

document.querySelector(".header-search_input").addEventListener("blur", () => {
  setTimeout(function () {
    document.querySelector(".myUL").style.display = "none";
  }, 200);
});

document
  .querySelector(".header-search_input")
  .addEventListener("focus", (name) => {
    if (name.value !== "")
      document.querySelector(".myUL").style.display = "block";
  });

var addedTypes = {};

let bookListArray = JSON.parse(localStorage.getItem("product"));
bookListArray.forEach(function (product) {
  let liName = document.createElement("li");
  let aName = document.createElement("a");
  liName.textContent = product.name;
  liName.addEventListener("click", () => {
    showProductsByName(product.name);
  });
  aName.href = "#";
  liName.appendChild(aName);
  document.querySelector(".myUL").appendChild(liName);
  // Kiểm tra xem loại sản phẩm đã được thêm vào danh sách chưa
  if (!addedTypes[product.type]) {
    let liType = document.createElement("li");
    let aType = document.createElement("a");
    liType.textContent = product.type;
    liType.addEventListener("click", () => {
      showProducts(product.type);
    });
    aType.href = "#"; // Add the appropriate link for the category here
    liType.appendChild(aType);
    document.querySelector(".myUL").appendChild(liType);
    // Đánh dấu loại sản phẩm đã được thêm vào danh sách
    addedTypes[product.type] = true;
  }
});

function showProducts(type) {
  let container = document.querySelector(".book-section_container");
  container.innerHTML = ""; // Clear the container
  let bookListArray = JSON.parse(localStorage.getItem("product"));
  bookListArray
    .filter((book) => book.type === type)
    .forEach((book) => {
      var html = `
        <div class="book-outer_container">
          <div class="book-inner_container">
            <img src="${book.url}" alt="" class="book-img"/>
            <h1 class="book-name">${book.name}</h1>
            <p class="book-author"><small><i>${book.author}</i></small></p>
            <p class="book-rating">${displayStar(book.rating)}</p>
            <p class="book-price">${formatTotal(book.price)}&#x20AB;</p>
            <div class="book-interaction">
              <button class="book-favorite book-btn" id="${book.id}">
                <i class="fa-regular fa-heart"></i>
              </button>
              <button class="book-cart book-btn" id="${book.id}">
                <i class="fa-solid fa-cart-plus"></i>
              </button>
            </div>
          </div>
        </div>`;
      container.innerHTML += html;
    });
  let bookBtn = document.querySelectorAll(".book-cart");
  bookBtn.forEach((item) => {
    item.addEventListener("click", () => displayBookLayout(item.id));
  });
}

function showProductsByName(name) {
  var container = document.querySelector(".book-section_container");
  container.innerHTML = ""; // Clear the container
  let bookListArray = JSON.parse(localStorage.getItem("product"));
  bookListArray
    .filter((book) => book.name === name)
    .forEach((book) => {
      var html = `
    <div class="book-outer_container">
      <div class="book-inner_container">
        <img src="${book.url}" alt="" class="book-img"/>
        <h1 class="book-name">${book.name}</h1>
        <p class="book-author"><small><i>${book.author}</i></small></p>
        <p class="book-rating">${displayStar(book.rating)}</p>
        <p class="book-price">${formatTotal(book.price)}&#x20AB;</p>
        <div class="book-interaction">
          <button class="book-favorite book-btn" id="${book.id}">
            <i class="fa-regular fa-heart"></i>
          </button>
          <button class="book-cart book-btn" id="${book.id}">
            <i class="fa-solid fa-cart-plus"></i>
          </button>
        </div>
      </div>
    </div>`;
      container.innerHTML += html;
    });
  let bookBtn = document.querySelectorAll(".book-cart");
  bookBtn.forEach((item) => {
    item.addEventListener("click", () => displayBookLayout(item.id));
  });
}

// Filter in dropdown

var flag = 0; // cờ kiểm tra nếu là lọc theo loại
var filterProducts = JSON.parse(localStorage.getItem("product"));

function filter(typeBook, typeSort) {
  let bookListArray = JSON.parse(localStorage.getItem("product"));
  filterProducts = bookListArray;
  if (typeBook)
    filterProducts = filterProducts.filter(
      (product) => product.type === typeBook
    );
  if (typeSort === "Asc") filterProducts.sort((a, b) => a.price - b.price);
  else filterProducts.sort((a, b) => b.price - a.price);

  return filterProducts;
}

const btnList = document.querySelectorAll(".BookList");
btnList.forEach((button) => {
  button.addEventListener("click", (type) => {
    filterProducts = filter(type.target.textContent, null);
    flag = 1;
    displayPageBook();
    displayContentBook();
  });
});
const btnSort = document.querySelectorAll(".sortBook");
btnSort.forEach((button) => {
  button.addEventListener("click", () => {
    let typeSort = button.id;
    filterProducts = filter(null, typeSort);
    displayPageBook();
    displayContentBook();
  });
});

// Book container JS

const bookPerPages = 15;
let totalPages = 0;
let currentPages = 1; // Current page
totalPages = Math.ceil(filterProducts.length / bookPerPages);

const displayStar = (rating) => {
  let star = "";
  for (let i = 0; i < rating; i++) star += "⭐";
  return star;
};

displayPageBook();
displayContentBook();

function displayContentBook() {
  let bookList = JSON.parse(localStorage.getItem("product"));
  const productMain = document.querySelector(".book-section_container");
  let bookListArray = filterProducts;
  productMain.innerHTML = "";
  // tính vị trí sách bắt đầu để hiển thị trong từng trang
  let beginBook = (currentPages - 1) * bookPerPages;
  let endBook = beginBook + bookPerPages;
  let pageBtn = document.querySelectorAll(".product-btn_page");
  pageBtn.forEach((button) => {
    if (button.textContent == currentPages) {
      button.style.color = "#fff";
      button.style.backgroundColor = "#00d664";
    } else {
      button.style.color = "#00d664";
      button.style.backgroundColor = "#fff";
    }
  });
  if (flag) {
    for (let i = 0; i < filterProducts.length; i++) {
      if (bookListArray[i]?.isDeleted != undefined) {
        continue;
      }
      let html = `
        <div class="book-outer_container">
          <div class="book-inner_container">
            <img src="${bookListArray[i].url}" alt="" class="book-img"/>
            <h1 class="book-name">${bookListArray[i].name}</h1>
            <p class="book-author"><small><i>${
              bookListArray[i].author
            }</i></small></p>
            <p class="book-rating">${displayStar(bookListArray[i].rating)}</p>
            <p class="book-price">${formatTotal(
              bookListArray[i].price
            )}&#x20AB;</p>
            <div class="book-interaction">
              <button class="book-favorite book-btn" id="${
                bookListArray[i].id
              }">
                <i class="fa-solid fa-heart"></i>
              </button>
              <button class="book-cart book-btn" id="${bookListArray[i].id}">
                <i class="fa-solid fa-cart-plus"></i>
              </button>
            </div>
          </div>
        </div>
        `;
      productMain.innerHTML += html;
    }
    flag = 0;
  } else {
    for (let i = beginBook; i < endBook; i++)
      if (bookListArray[i] && bookListArray[i]?.isDeleted == undefined) {
        let html = `
        <div class="book-outer_container">
          <div class="book-inner_container">
            <img src="${bookListArray[i].url}" alt="" class="book-img"/>
            <h1 class="book-name">${bookListArray[i].name}</h1>
            <p class="book-author"><small><i>${
              bookListArray[i].author
            }</i></small></p>
            <p class="book-rating">${displayStar(bookListArray[i].rating)}</p>
            <p class="book-price">${formatTotal(
              bookListArray[i].price
            )}&#x20AB;</p>
            <div class="book-interaction">
              <button class="book-favorite book-btn" id="${
                bookListArray[i].id
              }">
                <i class="fa-solid fa-heart"></i>
              </button>
              <button class="book-cart book-btn" id="${bookListArray[i].id}">
                <i class="fa-solid fa-cart-plus"></i>
              </button>
            </div>
          </div>
        </div>
      `;
        productMain.innerHTML += html;
      }
  }

  let bookBtn = document.querySelectorAll(".book-cart");
  bookBtn.forEach((item) => {
    item.addEventListener("click", () => displayBookLayout(item.id));
  });
}

function displayPageBook() {
  const productContainer = document.querySelector(".product-btn_container");
  productContainer.innerHTML = "";
  totalPages = Math.ceil(filterProducts.length / bookPerPages);
  productContainer.innerHTML += `<button class="product-btn product-btn_prev">&lt;</button>`;

  for (let i = 0; i < totalPages; i++) {
    let html = `
        <button class="product-btn product-btn_page" id="page-${i + 1}">${
      i + 1
    }</button>
      `;
    productContainer.innerHTML += html;
  }

  productContainer.innerHTML += `<button class="product-btn product-btn_next">&gt;</button>`;

  // xử lý ấn chuyển trang
  let pageBtn = document.querySelectorAll(".product-btn_page");
  let prevBtn = document.querySelector(".product-btn_prev");
  let nextBtn = document.querySelector(".product-btn_next");

  pageBtn.forEach((button) => {
    button.addEventListener("click", () => {
      currentPages = button.textContent;
      if (button.textContent == currentPages) {
        button.style.color = "#fff";
        button.style.backgroundColor = "#00d664";
      } else {
        button.classList.toggle("hidden");
      }
      displayContentBook();
    });
  });

  prevBtn.addEventListener("click", () => {
    if (currentPages > 1) currentPages--;
    displayContentBook();
  });

  nextBtn.addEventListener("click", () => {
    if (currentPages < totalPages) currentPages++;
    displayContentBook();
  });
}

// book layout to cart

function displayBookLayout(id) {
  let bookLayout = document.querySelector("#bookLayout");
  let bookContent = document.querySelector(".product-content");
  let bookListArray = JSON.parse(localStorage.getItem("product"));

  let bookInfo = bookListArray.filter((book) => book.id == id);
  bookContent.innerHTML = "";

  let description = "";
  if (
    bookInfo[0].type == "English" ||
    bookInfo[0].type == "Japanese" ||
    bookInfo[0].type == "Chinese"
  )
    description =
      "Sách về ngôn ngữ là hướng dẫn sâu sắc, khám phá vùng đất phong phú của từ ngữ, ngữ pháp và văn hóa ngôn ngữ. Từ vựng đa dạng và ví dụ thực tế giúp độc giả nâng cao kỹ năng ngôn ngữ một cách hiệu quả và thú vị.";
  else if (bookInfo[0].type == "Finance")
    description =
      "Cuốn sách kinh tế này cung cấp cái nhìn tổng quan sắc bén về thị trường và chính trị kinh tế, giúp độc giả hiểu rõ về các khía cạnh quan trọng của nền kinh tế hiện đại.";
  else if (bookInfo[0].type == "Manga")
    description =
      "Manga là truyện tranh đặc sắc của Nhật Bản. Kết hợp nét vẽ tinh tế với những câu chuyện đa dạng, cảm xúc và tình tiết hấp dẫn, manga mở ra góc nhìn về thế giới văn hóa độc đáo của đất nước Nhật Bản.";
  else if (bookInfo[0].type == "Psychology")
    description =
      "Cuốn sách về tâm lý này là một hướng dẫn sâu sắc, khám phá những chiều sâu của tâm hồn con người. Tác giả nêu rõ về cảm xúc, quyết định và mối quan hệ, tạo nên một hành trình tìm hiểu bản thân và phát triển tinh thần, giúp độc giả đạt được cân bằng và sự tự chủ trong cuộc sống.";
  let html = `
  <div class="product-close"><span>X</span></div>
  <div class="product-img"><img src="${bookInfo[0].url}" alt=""></div>
  <div class="product-info">
      <div class="product-name"><h2>${bookInfo[0].name}</h2></div>
      <div class="product-type"><h4>Thể loại: ${bookInfo[0].type}</h4></div>
      <div class="product-rating"><h4>Đánh giá: ${displayStar(
        bookInfo[0].rating
      )}</h4></div>
      <div class="product-price"><h4>Giá Tiền: ${bookInfo[0].price}</h4></div>
      <div class="product-description"><p>${description}</p></div>
      <div class="product-control-quantity">
          <button class="btn-des">-</button>
          <input type="text" value="1" id="product-quantity">
          <button class="btn-ins">+</button>
      </div> 
      <div><button class="add-to-cart">Thêm Vào Giỏ</button></div>
  </div>
  `;

  bookContent.innerHTML += html;
  bookLayout.style.display = "block";

  document.querySelector(".product-close").addEventListener("click", () => {
    bookLayout.style.display = "none";
  });

  let valueQuantity = document.querySelector("#product-quantity");
  document.querySelector(".btn-des").addEventListener("click", () => {
    if (valueQuantity.value > 1) valueQuantity.value--;
  });
  document.querySelector(".btn-ins").addEventListener("click", () => {
    valueQuantity.value++;
  });
  document
    .querySelector(".add-to-cart")
    .addEventListener("click", () =>
      addToCart(bookInfo[0], valueQuantity.value)
    );
}

// LOGIN, REGISTER
document.querySelectorAll(".modal__overlay").forEach((form)=>{
  form.addEventListener("click", () =>{
    modalRegister.style.display = "none";
    modalLogin.style.display = "none";
  });
})


accountBtn.forEach((btn) => {
  btn.addEventListener("click", () => {
    modalLogin.style.display = "block";
    modalRegister.style.display = "none";
  });
});

closeFormBtn.forEach((btn) => {
  btn.addEventListener("click", () => {
    modalLogin.style.display = "none";
    modalRegister.style.display = "none";
  });
});

btnOpenLogin.addEventListener("click", (event) => {
  event.preventDefault();
  modalLogin.style.display = "block";
  modalRegister.style.display = "none";
});
btnOpenRegister.addEventListener("click", (event) => {
  event.preventDefault();
  modalLogin.style.display = "none";
  modalRegister.style.display = "block";
});

 document.addEventListener("keydown", (event) => {
   if (event.key == "Enter" && modalLogin.style.display == "block") login(event);
 });
 document.addEventListener("keydown", (event) => {
   if (event.key == "Enter" && modalRegister.style.display == "block")
     createUser(event);
 });
// Register form

function validateEmail(email) {
  let regex = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
  return regex.test(email);
}
function validateUser(user) {
  let regex = /^[a-zA-Z0-9._-]{3,}$/;
  return regex.test(user);
}

function checkInputFromSignup(event) {
  let inputElement = event.target.value.trim();
  let errorElement = event.target.parentElement.querySelector(".form-message");

  if (inputElement === "")
    errorElement.innerHTML = "Vui lòng nhập thông tin vào!";
  else if (event.target.id === "username" && !validateUser(inputElement))
    errorElement.innerHTML =
      "Tài khoản đăng nhập phải có ít nhất 3 kí tự trở lên, không chứa kí tự đặc biệt";
  else if (event.target.id === "password" && inputElement.length < 6)
    errorElement.innerHTML = "Mật khẩu phải có ít nhất 6 kí tự.";
  else if (event.target.id === "email" && !validateEmail(inputElement))
    errorElement.innerHTML = "Địa chỉ email không hợp lệ.";
  else if (event.target.id === "fillpassword" &&inputElement != inputPasswordSignup.value)
    errorElement.innerHTML = "Mật khẩu nhập lại không giống nhau";
  else errorElement.innerHTML = "";
}

inputUsernameSignUp.addEventListener("blur", checkInputFromSignup);
inputEmailSignUp.addEventListener("blur", checkInputFromSignup);
inputPasswordSignup.addEventListener("blur", checkInputFromSignup);
fillPassSignup.addEventListener("blur", checkInputFromSignup);

document.querySelector(".signupForm").addEventListener("submit", createUser);
document.querySelector(".loginForm").addEventListener("submit", login);

function createUser(event) {
  event.preventDefault();
  userList = JSON.parse(localStorage.getItem("user"));
  let username = inputUsernameSignUp.value.trim();
  let email = inputEmailSignUp.value.trim();
  let password = inputPasswordSignup.value.trim();
  let passwordAgain=fillPassSignup.value.trim();
  if (!username || !email || !password || !passwordAgain) {
    alert("Vui lòng nhập đủ thông tin đăng ký!");
    return false;
  }
  if ( password != passwordAgain)
  {
    return false;
  }
  let newUser = {
    username: username,
    password: password,
    email: email,
    id: userList.length + 1,
    dateSignUp: "",
  };
  // kiểm tra trùng tên đăng nhập
  for (let i = 0; i < userList.length; i++) {
    if (newUser.username == userList[i].username) {
      inputUsernameSignUp.parentElement.querySelector(
        ".form-message"
      ).innerHTML = "Tên đăng nhập đã có người sử dụng";
      inputUsernameSignUp.focus();
      return false;
    }
  }
  newUser.dateSignUp = new Intl.DateTimeFormat("vi-VN", {
    day: "2-digit",
    month: "2-digit",
    year: "numeric",
  }).format(new Date());
  userList.push(newUser);
  localStorage.setItem("user", JSON.stringify(userList));
  alert("Đã đăng ký thành công");
  modalRegister.style.display = "none";
  window.location.reload();
}
// Login form
//
var currentCustomer;
function login(event) {
  event.preventDefault();
  userList = JSON.parse(localStorage.getItem("user"));
  if (!userLogin.value || !passLogin.value) {
    alert("Vui lòng nhập thông tin đăng nhập!");
    return false;
  }

  for (let i = 0; i < userList.length; i++) {
    if (
      userLogin.value == userList[i].username &&
      passLogin.value == userList[i].password
    ) {
      localStorage.setItem("userLogin", JSON.stringify(userList[i]));
      currentCustomer = userList[i];
      window.location.reload();
      return true;
    }
  }
  document.querySelector(".loginForm .form-message").innerHTML =
    "Tên đăng nhập hoặc mật khẩu không đúng";
}

userLogout.forEach((item) => {
  item.addEventListener("click", () => {
    localStorage.removeItem("userLogin");
    location.href = "index.html";
  });
});

function checklogin() {
  if (localStorage.getItem("userLogin")) {
    let user = JSON.parse(localStorage.getItem("userLogin"));

    if (user.isDeleted == true) {
      alert("Tài khoản đã bị vô hiệu hóa !!!");
    } else {
      let headerUser = document.querySelectorAll(".header-user");
      headerUser.forEach((item) => {
        item.style.display = "block";
      });
      let userName = document.querySelectorAll(".user-name");
      userName.forEach((item) => {
        item.innerHTML = user.username;
      });
      let headerAccount = document.querySelectorAll(".header-account");
      headerAccount.forEach((item) => {
        item.style.display = "none";
      });
      if (user.username == "admin" && user.password == "admin")
        document.querySelector(".adminControl").style.display = "block";
    }
  }
}
// another
function innerIntroduce()
{
  let mainContent=document.querySelector(".main-content");
  mainContent.innerHTML=`
  <div class="introduce-content">      
  <section class="introduce-section">
  <div class="introduce-container">
    <h3 class="introduce-tittle">Về chúng tôi</h3>
    <p>
      Chúng tôi là một trang web bán sách trực tuyến, chuyên cung cấp các loại sách đa dạng, từ sách Tiếng Nhật, sách Kinh tế, sách Tiếng Trung, sách Tiếng Nhật, Truyện tranh,... 
    </p>
    <p>
      Với đội ngũ nhân viên chuyên nghiệp và tận tâm, chúng tôi cam kết mang đến cho khách hàng những trải nghiệm mua sắm sách online tuyệt vời nhất.
    </p>
  </div>
</section>
<section class="introduce-section">
  <div class="introduce-container">
    <h3 class="introduce-tittle">Sứ mệnh</h3>
    <p>
      Chúng tôi mong muốn mang đến cho mọi người cơ hội tiếp cận với tri thức và văn hóa thông qua những cuốn sách chất lượng.
    </p>
    <p>
      Chúng tôi cũng mong muốn góp phần xây dựng một cộng đồng yêu sách và phát triển văn hóa đọc tại Việt Nam.
    </p>
  </div>
</section>
<section class="introduce-section">
  <div class="introduce-container">
    <h3 class="introduce-tittle">Tầm nhìn</h3>
    <p>
      Trở thành trang web bán sách trực tuyến hàng đầu tại Việt Nam, cung cấp cho khách hàng những sản phẩm và dịch vụ tốt nhất.
    </p>
  </div>
</section>
<section class="introduce-section">
  <div class="introduce-container">
    <h3 class="introduce-tittle">Các sản phẩm và dịch vụ</h3>
    <ul>
      <li>Sách Tiếng Anh</li>
      <li>Sách Kinh Tế</li>
      <li>Sách Tiếng Nhật</li>
      <li>Sách Tiếng Trung</li>
      <li>Truyện tranh</li>
      <li>Sách Tâm lý</li>
    </ul>
  </div>
</section>
<section class="introduce-section">
  <div class="introduce-container">
    <h3 class="introduce-tittle">Ưu điểm của trang web</h3>
    <ul>
      <li>Đa dạng về sản phẩm và dịch vụ</li>
      <li>Giá cả cạnh tranh</li>
      <li>Giao hàng nhanh chóng</li>
      <li>Hỗ trợ khách hàng tận tình</li>
    </ul>
  </div>
</section>
</div>
`;
}
function innerService(){
  let mainContent=document.querySelector(".main-content");
  mainContent.innerHTML=`               
  <div class="service-content">
  <h2 class="service-tittle">Chính sách Đổi Trả</h2>
  <section class="service-section">
      <ul class="service-container">
          <li><h3 class="service-container-tittle">Điều kiện để đổi trả sản phẩm</h3></li>
          <li>Sản phẩm phải còn nguyên vẹn, chưa qua sử dụng.</li>
          <li>Sản phẩm phải có đầy đủ tem mác, nhãn, bao bì.</li>
          <li>Sản phẩm phải có đầy đủ phụ kiện đi kèm (nếu có).</li>
          <li>Sản phẩm phải được gửi kèm hóa đơn mua hàng.</li>
          <li>Thời gian đổi trả: Khách hàng có quyền đổi trả sản phẩm trong vòng 7 ngày.</li>
          <li><h3 class="service-container-tittle">Hình thức đổi trả</h3></li>
          <li>Liên hệ với bộ phận chăm sóc khách hàng để được hướng dẫn.</li>
          <li>Gửi gmail qua cho shop để được xử lý.</li>
          <li><h3 class="service-container-tittle">Chính sách hoàn tiền</h3></li>
          <li>Khách hàng chắc chắn sẽ được hoàn trả đầy đủ.</li>
          <li>Nếu quá thời gian kể từ 1 tuần đến 2 tuần: Khách hàng sẽ được hoàn lại 50%.</li>
          <li>Trường hợp không được đổi trả: Sản phẩm không còn nguyên vẹn, không có hóa đơn, v.v...</li>
      </ul>
  </section>
  <h2 class="service-tittle">Chính sách Bảo Mật</h2>
  <section class="service-section">
      <ul class="service-container">
          <li><h3 class="service-container-tittle">Về bảo mật của tài khoản cá nhân</h3></li>
          <li>Mọi thông tin về số điện thoại, địa chỉ, các đơn hàng sẽ được bảo mật chặt chẽ.</li>
          <li>Thông tin cá nhân thu thập được sẽ chỉ được sử dụng trong dịch vụ mua hàng</li>
          <li>Phạm vi thu thập thông tin: Họ tên, địa chỉ, số điện thoại, email, thông tin đơn hàng.</li>
          <li>Thời gian lưu trữ thông tin: Tối đa 5 năm từ ngày tạo tài khoản.</li>
          <li>Phương thức thu thập thông tin: Tự cung cấp khi tạo tài khoản, thông qua cookies.</li>
          <li>Phương thức bảo mật thông tin: Mã hóa thông tin, sử dụng firewall, và các biện pháp bảo mật khác.</li>
          <li>Quyền lợi của khách hàng: Truy cập, chỉnh sửa, yêu cầu xóa bỏ thông tin cá nhân, khiếu nại.</li>
      </ul>
  </section>
  <h2 class="service-tittle">Chính sách Vận Chuyển</h2>
  <section class="service-section">
      <ul class="service-container">
          <li><h3 class="service-container-tittle">Khu vực giao hàng</h3></li>
          <li>Chúng tôi cung cấp dịch vụ giao sách với trụ sở chính ở TPHCM và Hà Nội.</li>
          <li>Chúng tôi cung cấp dịch vụ chuyển phát nhanh và giao hàng tận nơi đến các vùng, thành phố trên khắp cả nước.</li>
          <li><h3 class="service-container-tittle">Thời gian giao và Phương thức vận chuyển</h3></li>
          <li>Phương thức vận chuyển: Giao hàng tận nơi, nhận hàng tại cửa hàng.</li>
          <li>Thời gian vận chuyển: Phụ thuộc vào phương thức vận chuyển được lựa chọn.</li>
          <li>Phí vận chuyển: Tính dựa trên trọng lượng và khoảng cách.</li>
          <li><h3 class="service-container-tittle">Đổi trả hư hỏng do vận chuyển</h3></li>
          <li>Đổi trả do lỗi vận chuyển: Chúng tôi hoàn toàn chịu trách nhiệm bồi thường và đổi mới nếu có lỗi do bên vận chuyển.</li>
      </ul>
  </section>
</div>`
}

document.querySelector(".introduce-page").addEventListener("click",innerIntroduce);
document.querySelector(".service-page").addEventListener("click",innerService);
document.querySelector(".contact-page").addEventListener("click", ()=>{
  document.querySelector(".footer").scrollIntoView({behavior:"smooth"});
});
document.querySelectorAll(".policy-info").forEach((e)=>{
  e.addEventListener("click",innerService)
});
// go to Top web
document.querySelector(".goToTop").addEventListener("click",()=>{
  document.querySelector(".header-container").scrollIntoView({behavior:"smooth"});
});
window.onscroll = function()
{
  let gotoTop=document.querySelector(".goToTop");
  if (document.documentElement.scrollTop > 900)
      gotoTop.style.display = "block";
  else 
       gotoTop.style.display = "none";
}

//cart
// add to cart and show

function addToCart(book, quantityBook) {
  let productArray = JSON.parse(localStorage.getItem("product"));
  let productArrayLength = productArray.length;

  let productItem = {
    name: "",
    type: "",
    price: 0,
    url: "",
    id: "",
    quantity: 0,
  };

  let cartArray = JSON.parse(localStorage.getItem("cartCustomer")) || [];

  for (let i = 0; i < productArrayLength; i++) {
    if (productArray[i].id == book.id) {
      productItem.name = productArray[i].name;
      productItem.type = productArray[i].type;
      productItem.price = productArray[i].price;
      productItem.url = productArray[i].url;
      productItem.id = productArray[i].id;
      productItem.quantity = quantityBook;

      let existProduct = cartArray.findIndex(
        (item) => item.id === productItem.id
      );
      if (existProduct !== -1)
        cartArray[existProduct].quantity =
          parseInt(cartArray[existProduct].quantity) +
          parseInt(productItem.quantity);
      else cartArray.unshift(productItem);

      localStorage.setItem("cartCustomer", JSON.stringify(cartArray));
      alert("Thêm sách thành công");
      showCart();
      headerCartQuantity();
      let bookLayout = document.querySelector("#bookLayout");
      bookLayout.style.display = "none";
    }
  }
}

showCart();
function showCart() {
  let cartList = document.querySelector("#showcart .header-cart-list");
  let cartArray = JSON.parse(localStorage.getItem("cartCustomer"));

  cartList.innerHTML = `<div class="cartTittle"><h5>Sản phẩm thêm vào</h5></div>`;
  if (cartArray !== null)
    for (let i = 0; i < cartArray.length; i++) {
      let html = `<div class="cartItem">
        <div class="cart-item-img"><img src="${cartArray[i].url}" alt=""></div>
        <div class="cart-item-name">${cartArray[i].name}</div>
        <div class="cart-item-price">${formatTotal(
          cartArray[i].price
        )}&#x20AB;</div>
        <button><i class="cart-item-remove fa-solid fa-x" id="${i}"></i></button>
      </div>
      `;
      cartList.innerHTML += html;
    }
  else {
    let html = `
      <div><p>Không có sản phẩm nào trong giỏ hàng</p></div>
    `;
    cartList.innerHTML += html;
  }
}
// remove from cart
let btnRemoveAllCart = document.querySelector(".removeAllCart");

function removeCartItem(item) {
  let cartArray = JSON.parse(localStorage.getItem("cartCustomer"));
  cartArray.splice(item, 1);
  localStorage.setItem("cartCustomer", JSON.stringify(cartArray));
  showCart();
  headerCartQuantity();
  showCustomerCart();
  cartLayout();
}

btnRemoveAllCart.addEventListener("click", () => {
  localStorage.removeItem("cartCustomer");
  showCart();
  headerCartQuantity();
  showCustomerCart();
});

document
  .querySelector(".header-cart-list")
  .addEventListener("click", (event) => {
    if (event.target.classList.contains("cart-item-remove")) {
      removeCartItem(event.target.id);
    }
  });

// Main Cart Layout

function showCustomerCart() {
  let contentCart = document.querySelector(".content-cart .boxcontent");
  let cartArray = JSON.parse(localStorage.getItem("cartCustomer"));
  let totalPrice = 0;
  contentCart.innerHTML = "";
  contentCart.innerHTML += `
    <div class="content-cart-group">
      <div class="content-cart-info">STT</div>
      <div class="content-cart-info">Sản Phẩm</div>
      <div class="content-cart-info">Giá</div>
      <div class="content-cart-info">Số Lượng</div>
      <div class="content-cart-info">Thành Tiền</div>
      <div class="content-cart-info">Thao Tác</div>
    </div>`;
  if (cartArray !== null)
    for (let i = 0; i < cartArray.length; i++) {
      let html = ` <div class="cart-item-group">
            <div class="cart--item cart--item-stt">${i + 1}</div>
            <div class="cart--item cart--item-img"><img src="${
              cartArray[i].url
            }"></div>
            <div class="cart--item cart--item-price">${formatTotal(
              cartArray[i].price
            )}&#x20AB;</div>
            <div class="cart--item cart--group-quantity">
                <button class="cart-quantity-des" onclick="quantityDes(${
                  cartArray[i].id
                });">-</button>
                <div class="cart--item-quantity">${cartArray[i].quantity}</div>
                <button class="cart-quantity-ins" onclick="quantityIns(${
                  cartArray[i].id
                });">+</button>
            </div>
            <div class="cart--item cart--item-sumPrice">${formatTotal(
              cartArray[i].price * cartArray[i].quantity
            )}&#x20AB;</div>
            <button class="cart--item"><i class="cart--item-remove fa-solid fa-x" id="${i}"></i></button>
          </div>
        `;
      totalPrice += cartArray[i].price * cartArray[i].quantity;
      contentCart.innerHTML += html;
    }
  contentCart.innerHTML += `
        <div class=cart-item-group>
          <div class="cart--item cart--price">Tổng</div>
          <div class="cart--item cart--price">${formatTotal(
            totalPrice
          )}&#x20AB;</div>
      `;
}

// tăng giảm số lần trong giỏ
function quantityIns(idBook) {
  let cartArray = JSON.parse(localStorage.getItem("cartCustomer"));
  for (let i = 0; i < cartArray.length; i++) {
    if (cartArray[i].id == idBook) cartArray[i].quantity++;
  }
  localStorage.setItem("cartCustomer", JSON.stringify(cartArray));
  showCustomerCart();
  headerCartQuantity();
}

function quantityDes(idBook) {
  let cartArray = JSON.parse(localStorage.getItem("cartCustomer"));
  for (let i = 0; i < cartArray.length; i++) {
    if (cartArray[i].id == idBook)
      if (cartArray[i].quantity > 1) cartArray[i].quantity--;
  }
  localStorage.setItem("cartCustomer", JSON.stringify(cartArray));
  showCustomerCart();
  headerCartQuantity();
}

function cartLayout() {
  let mainContent = document.querySelector(".main-content");
  mainContent.innerHTML = "";
  let html = `<div class="Customer-info">
  <div class="content-customer">
    <h1 class="boxtitle">THÔNG TIN NHẬN HÀNG</h1>
    <div class="boxcontent">
      <div class="customer-group">
        <label for="">Họ Tên:</label>
        <div>
          <input type="text" class="customer-input customer-name" id="customerName" placeholder="Nhập Họ Tên...">
          <span class="errorCustomer"></span>
        </div>
      </div>
      <div class="customer-group">
        <label for="">Địa Chỉ Giao:</label>
        <div>
          <input type="text" class="customer-input customer-location" id="customerLocation" placeholder="Nhập Địa Chỉ Giao...">
          <span class="errorCustomer"></span>
        </div>
      </div>
      <div class="customer-group">
        <label for="">Số Điện Thoại:</label>
        <div>
          <input type="text" class="customer-input customer-phone" id="customerPhone" placeholder="Nhập Số Điện Thoại...">
          <span class="errorCustomer"></span>
        </div>
      </div>
      <div class="customer-group">
        <label for="">Email:</label>
        <div>
          <input type="text" class="customer-input customer-email" id="customerEmail" placeholder="Nhập Email...">
          <span class="errorCustomer"></span>
        </div>
      </div>
    </div>
  </div>

  <div class="content-customer">
      <h1 class="boxtitle">PHƯƠNG THỨC THANH TOÁN</h1>
      <div class="boxcontent">
          <div class="payment_menthod">
            <div class="payment"><input type="radio" name="payment_menthods" value="Tiền mặt">Tiền mặt</div>
            <div class="payment"><input type="radio" name="payment_menthods" value="Chuyển khoản Ngân Hàng">Chuyển khoản Ngân Hàng</div>
          </div>
      </div>
  </div>

</div>

<div class="content-cart">
    <h1 class="boxtitle">GIỎ HÀNG</h1>
    <div class="boxcontent">
    </div>
    <div class="btnCart-submit" style="position: absolute; right: 10px;">
  <button class="submit-order">ĐỒNG Ý ĐẶT HÀNG</button>
</div>
</div>
`;
  mainContent.innerHTML += html;

  showCustomerCart();

  document.querySelectorAll(".cart--item-remove").forEach((item) => {
    item.addEventListener("click", (event) => {
      removeCartItem(event.target.id);
    });
  });

  // xử lý đặt hàng
  // thông tin đặt

  function validateName(name) {
    let fullnameRegex = /^[A-Za-z][a-z]*(\s[A-Za-z][a-z]*)*$/;
    return fullnameRegex.test(name);
  }
  function validateEmail(email) {
    let emailRegex = /^\w+@[a-zA-Z_]+?\.[a-zA-Z]{2,3}$/;
    return emailRegex.test(email);
  }
  function validatePhone(phone) {
    let phoneRegex = /^[0][0-9]{8,9}$/;
    return phoneRegex.test(phone);
  }
  let customerName = document.querySelector(".customer-name");
  let customerLocation = document.querySelector(".customer-location");
  let customerPhone = document.querySelector(".customer-phone");
  let customerEmail = document.querySelector(".customer-email");
  let customerPayMethod = document.querySelector(".payment_menthod");
  let payMethod;

  function checkOrder(event)
  {
    let inputCustomer = event.value.trim();
    if (event.id === "customerName" && !validateName(inputCustomer))
        return false;
    else if ( event.id === "customerPhone" &&!validatePhone(inputCustomer))
        return false;
    else if (event.id === "customerEmail" &&!validateEmail(inputCustomer))
        return false;
    return true;
  }

  function checkInfo(event) {
    console.log(event);
    let inputCustomer = event.target.value.trim();
    let errorMessage =
      event.target.parentElement.querySelector(".errorCustomer");
    if (inputCustomer === "")
      errorMessage.innerHTML = "Vui lòng nhập thông tin giao hàng!";
    else if (event.target.id === "customerName" && !validateName(inputCustomer))
      errorMessage.innerHTML =
        "Họ và tên nhập vào không hợp lệ, chỉ nhận kí tự";
    else if ( event.target.id === "customerPhone" &&!validatePhone(inputCustomer))
      errorMessage.innerHTML = "Số điện thoại nhập không hợp lệ";
    else if (event.target.id === "customerEmail" &&!validateEmail(inputCustomer))
      errorMessage.innerHTML = "Email không đúng định dạng";
    else errorMessage.innerHTML = "";
  }

  customerName.addEventListener("blur", checkInfo);
  customerLocation.addEventListener("blur", checkInfo);
  customerPhone.addEventListener("blur", checkInfo);
  customerEmail.addEventListener("blur", checkInfo);
  customerPayMethod.addEventListener("change", (event) => {
    if (event.target.tagName === "INPUT" && event.target.type === "radio");
    payMethod = event.target.value;
  });

  function addToOrder() {
    let customerCart = JSON.parse(localStorage.getItem("cartCustomer"));
    let customerInfo = JSON.parse(localStorage.getItem("userLogin"));
    let orderBook = "";
    let totalPrice = 0;
    if (!customerInfo) {
      alert("vui lòng đăng nhập trước khi đặt hàng !");
      return false;
    }
    if (!customerCart || customerCart == "") {
      alert("Giỏ hàng trống không có gì để đặt cả :< ");
      return false;
    }
    if (!checkOrder(customerName) || !checkOrder(customerPhone) || !checkOrder(customerEmail) || !checkOrder(customerLocation)) {
      alert("Vui lòng nhập đúng thông tin để đặt hàng !");
      return false;
    }
    if (!payMethod) {
      alert("Vui lòng chọn phương thức thanh toán !");
      return false;
    }

    const cartLength = customerCart.length;

    let orderInfo = {
      id: "",
      name: "",
      phone: "",
      address: "",
      accCustomer: "",
      bookInfo: "",
      dateOrder: "",
      totalPrice: 0,
      status: 0,
      orderBook: "",
    };
    orderInfo.id = 0;
    orderInfo.name = customerName.value.trim();
    orderInfo.phone = customerPhone.value.trim();
    orderInfo.address = customerLocation.value.trim();
    orderInfo.accCustomer = customerInfo;
    orderInfo.bookArr = customerCart;

    for (let i = 0; i < cartLength; i++) {
      totalPrice += customerCart[i].price * customerCart[i].quantity;
      orderBook += `${
        customerCart[i].quantity + " x " + customerCart[i].name + "; "
      }`;
    }
    orderInfo.totalPrice = totalPrice;
    orderInfo.orderBook = orderBook;
    orderInfo.dateOrder = new Intl.DateTimeFormat("vi-VN", {
      day: "2-digit",
      month: "2-digit",
      year: "numeric",
    }).format(new Date());

    if (localStorage.getItem("orderCustomer")) {
      let customerOrder = JSON.parse(localStorage.getItem("orderCustomer"));
      orderInfo.id = customerOrder.length;
      customerOrder.unshift(orderInfo);
      localStorage.setItem("orderCustomer", JSON.stringify(customerOrder));
    } else {
      let customerOrder = [];
      orderInfo.id = customerOrder.length;
      customerOrder.unshift(orderInfo);
      localStorage.setItem("orderCustomer", JSON.stringify(customerOrder));
    }

    alert("Cảm ơn bạn đã tin tưởng đặt hàng của chúng tôi ^^");
    localStorage.removeItem("cartCustomer");
    cartLayout();
    showCart();
    headerCartQuantity();
  }

  var submitOrder = document.querySelector(".submit-order");
  submitOrder.addEventListener("click", addToOrder);
}

let cartContent = document.querySelectorAll(".header-utility_cart");
cartContent.forEach((item) => {
  item.addEventListener("click", cartLayout);
});

// xử lý layout  order

//hủy đơn
function removeOrder(item) {
  let orderArray = JSON.parse(localStorage.getItem("orderCustomer"));
  if (confirm("Bạn muốn hủy đơn sao :(((")) {
    let index = orderArray.findIndex((tmp) => tmp.id == item);
    orderArray.splice(index, 1);
  }

  localStorage.setItem("orderCustomer", JSON.stringify(orderArray));
  orderLayout();
}

function showCustomerOrder() {
  let contentOrder = document.querySelector(".Customer-order .boxcontent");
  let orderArray = JSON.parse(localStorage.getItem("orderCustomer"));
  let userLogin = JSON.parse(localStorage.getItem("userLogin"));
  contentOrder.innerHTML = "";
  contentOrder.innerHTML += `
  <div class="content-order-group">
      <div class="content-order-info">MÃ ĐƠN HÀNG</div>
      <div class="content-order-info content-order-product">SẢN PHẨM</div>
      <div class="content-order-info">NGÀY ĐẶT</div>
      <div class="content-order-info">TỔNG TIỀN</div>
      <div class="content-order-info">TRẠNG THÁI</div>
      <div class="content-order-info">HỦY ĐƠN</div>
    </div>
  `;
  for (let i = 0; i < orderArray.length; i++) {
    let html = ``;
    if (userLogin.id == orderArray[i].accCustomer.id) {
      html = `
      <div class="order-item-group">
        <div class="order-item">${orderArray[i].id}</div>
        <div class="order-item order-item-info">${orderArray[i].orderBook
          .split(";")
          .join("<br>")}</div>
        <div class="order-item">${orderArray[i].dateOrder}</div>
        <div class="order-item">${formatTotal(
          orderArray[i].totalPrice
        )}&#x20AB;</div>
        <div class="order-item" style="color: ${orderStatusStyle(
          orderArray[i].status
        )};font-weight: bolder;">${orderStatus(orderArray[i].status)}</div>
        <button class="order-item order-cancel" id="${
          orderArray[i].id
        }">X</button>
    </div>
      `;
    } else {
      contentOrder.innerHTML += html;
    }
    contentOrder.innerHTML += html;
  }

  document.querySelectorAll(".order-cancel").forEach((item) => {
    item.addEventListener("click", (event) => {
      removeOrder(event.target.id);
    });
  });
}

function orderLayout() {
  let mainContent = document.querySelector(".main-content");
  mainContent.innerHTML = "";
  let html = `
  <div class="Customer-order">
  <h1 class="boxtitle">ĐƠN HÀNG CỦA BẠN</h1>
  <div class="boxcontent">
  </div>
</div>
  `;
  mainContent.innerHTML += html;

  showCustomerOrder();
}

let orderContent = document.querySelectorAll(".header-utility_order");
orderContent.forEach((item) => item.addEventListener("click", orderLayout));

// Admin

const toggleHidden = (element) => {
  element.classList.toggle("hidden");
};
const addLayoutEvent = () => {
  layout.addEventListener("click", () => {
    toggleHidden(layout);
  });
};
addLayoutEvent();
const generatePaginationButton = () => {
  let bookListArray = JSON.parse(localStorage.getItem("product"));
  let page = (bookListArray.length - deletedBook) / bookPerPage;
  let btnHtml = "";
  let count = 1;
  while (count < page + 1) {
    btnHtml += `<button class="btn-pagination btn-pagination_page" id="page-${Math.round(
      count
    )}">${Math.round(count)}</button>\n`;
    count++;
  }
  return btnHtml;
};

function headerAdmin() {
  let headerUtility = document.querySelector(".header-utility");
  let headerSearch = document.querySelector(".header-search");
  let headerCart = document.querySelector(".header-cart");
  let headerOrder = document.querySelector(".header-order");
  headerUtility.style.display = "flex";
  headerUtility.style.justifyContent = "center";
  headerSearch.style.display = "none";
  headerCart.style.display = "none";
  headerOrder.style.display = "none";
}

const generateConditionalInteract = (book) => {
  const buttonHtml =
    adminMode == 1
      ? ` <button class="btn-book_manipulate btn-book" id="book-${book.id}">
 <i class="fa-solid fa-pencil"></i>
</button>
<button class="btn-book_delete btn-book" id="book-${book.id}">
<i class="fa-solid fa-trash"></i>
</button>`
      : ` <button class="btn-book_favorite btn-book" id="book-${book.id}">
  <i class="fa-solid fa-heart"></i>
</button>
<button class="btn-book_cart btn-book" id="book-${book.id}">
  <i class="fa-solid fa-cart-plus"></i>
</button>`;

  return buttonHtml;
};

const insertBookSection = (parent) => {
  currentPage = 0;
  const btnAddHtml =
    adminMode == 1
      ? ` <button class="btn-option_manipulate btn-manipulate_add btn-admin"><i class="fa-solid fa-plus"></i></button>`
      : "";
  const bookSectionHtml = `<section class="book-section_outer">
    <section class="admin-product_container book-section_inner"></section>
    <div class="pagination-btn_container">
      <button class="btn-pagination_previous btn-pagination">
        <
      </button>
      ${generatePaginationButton()}
      <button class="btn-pagination_next btn-pagination ">
        >
      </button>
    </div>
  </section>
  ${btnAddHtml}`;

  parent.innerHTML = bookSectionHtml; //Them bookSection vao trang
  bookSectionOuterContainer = document.querySelector(".book-section_outer");
  bookSecionInnerContainer = document.querySelector(".book-section_inner");
  btnPaginationPrevious = document.querySelector(".btn-pagination_previous");
  btnPaginationNext = document.querySelector(".btn-pagination_next");
  btnPaginationList = document.querySelectorAll(".btn-pagination_page");
  displayBook();
  addPaginationEvent();
  if (adminMode == 1) {
    //Chi add cac su kien delete va manipulate neu vao che do chinh sua sach cua admin
    btnManipulateAdd = document.querySelector(".btn-manipulate_add");
    addDeleteProductEvent();
    addManipulateEvent();
    manipulateAddBook();
    addBlurEvent();

  }
  headerAdmin();
};

const displayBook = () => {
  let bookListArray = JSON.parse(localStorage.getItem("product"));
  let bookHTML = "";
  const bookStartIndex = currentPage * bookPerPage;
  let bookCount = currentPage * bookPerPage + bookPerPage; //Vi tri cua cuon sach cuoi cung phai display trong vong lap
  for (
    let i = bookStartIndex; //Vi tri index cua cuon sach phai display dau tien dua theo trang hien tai
    i < bookCount && i < bookListArray.length; //Vong lap chi dung khi den vi tri sach cuoi cung phai display trong trang hoac khi da het Array sach
    i++
  ) {
    if (bookListArray[i]?.isDeleted != undefined) {
      bookCount++;
      continue; //Neu sach da co thuoc tinh da~ xoa' thi tang so sach phai display trong trang len va nhay qu alan lap tiep theo
    }
    bookHTML += `<div class="book-outer">
    <div class="book-inner">
      <img src="${bookListArray[i].url}" alt="" class="book-img"/>
      <h1 class="book-name">${bookListArray[i].name}</h1>
      <p class="book-author">
        <small><i>${bookListArray[i].author}</i></small>
      </p>
      <p class="book-rating">${displayStar(bookListArray[i].rating)}</p>
      <p class="book-price">${formatTotal(bookListArray[i].price)}&#x20AB;</p>
      <div class="book-interact  id="book-${bookListArray[i].id}">
     ${generateConditionalInteract(bookListArray[i])}
    </div>
    </div>
    </div>`;
  }
  bookSecionInnerContainer.innerHTML = bookHTML; //Them so sach vua duoc cong don vao 1 template String  vao inner boook section
  if (adminMode == 1) {
    btnDeleteProductList = document.querySelectorAll(".btn-book_delete"); //Lay ra cac nut xoa sach cua tung div sach co trong trang
    btnManipulateProductList = document.querySelectorAll(
      ".btn-book_manipulate"
    ); //Lay ra cac nut sua sach cua tung div sach co trong trang
  } else {
    btnBookCartList = document.querySelectorAll(".btn-book_cart");
    btnBookFavoriteList = document.querySelectorAll(".btn-book_favorite");
  }
};

const addPaginationEvent = () => {
  let bookListArray = JSON.parse(localStorage.getItem("product"));
  totalPage = Math.ceil((bookListArray.length - deletedBook) / bookPerPage); //Dung ceil de lam tron so trang cho cac cuon sach le ra 1 trang moi.Tru them deletebook de giam so phan tu tao ra trang moi vi se khong display no ra
  btnPaginationList[0].classList.add("active-btn"); //Khi vua load pagination trang dau tien hay phan tu thu [0] cua list btnPagination se la activeButton
  const updateButtonStates = () => {
    btnPaginationPrevious.disabled = currentPage === 0; //Cap nhat button prev va next lien tuc de disable no khi bam cac so page khac nhau
    btnPaginationNext.disabled = currentPage === totalPage - 1;
  };
  const handlePageButtonClick = (btn) => {
    const btnId = parseInt(btn.getAttribute("id").split("-")[1]) - 1; //Id cua button co dang page-x nen ta se split ra duoc 2 phan tu va phan tu thu 2 =[1] se la  id page hin tai sau do parseInt vi ban dau no la string trong Html
    if (btnId !== currentPage) {
      currentPage = btnId; //page hien tai se tuong ung voi id da dat cho button sau khi bam
      displayBook(); //Load sach tuong ung voi trang hien tai
      updateButtonStates(); //Cap nhat trang thai cho 2 button prev va next de disabled neu la trang dau hoac trang cuoi
      highlightActiveButton(); //highlight cho button duoc chon hien tai
    }
  };
  const highlightActiveButton = () => {
    btnPaginationList.forEach((btn) => {
      const btnId = parseInt(btn.getAttribute("id").split("-")[1]) - 1; //Lay id cua button
      if (btnId === currentPage) {
        btn.classList.add("active-btn"); //Thay doi mau sac cho btn vua duoc bam
      } else {
        btn.classList.remove("active-btn"); //Xoa class highlight cho button neu khong phai nut vua duoc bam, hay clear trang thai cho nut cu
      }
    });
  };

  btnPaginationPrevious.disabled = true; ///Khi vua vao thi se o trang 1 nen se disabled nut prev
  btnPaginationNext.addEventListener("click", () => {
    currentPage++; //Khi bam vao next thi trang hien tai tang len 1
    displayBook();
    updateButtonStates(); //Cap nhat trang thai cho nut cua trang+1
    highlightActiveButton(); //Highlight cho nut vua duoc active va go di mau cua nu cu
  });

  btnPaginationPrevious.addEventListener("click", () => {
    if (currentPage === 0) return;
    currentPage--;
    displayBook();
    updateButtonStates();
    highlightActiveButton();
    if (adminMode == 1) {
      //Neu o trang thai admin va o mode manage product thi se them nut xoa san pham cho tung cuon sach va them su kien xoa va su kien sua thong tin sach
      addDeleteProductEvent();
      addManipulateEvent();
    }
  });

  btnPaginationList.forEach((btn) => {
    btn.addEventListener("click", () => {
      handlePageButtonClick(btn);
      if (adminMode == 1) {
        addDeleteProductEvent();
        addManipulateEvent();
      }
    });
  });
};

const addDeleteProductEvent = () => {
  btnDeleteProductList.forEach((btn) => {
    btn.addEventListener("click", () => {
      if (window.confirm("Xac nhan xoa san pham: ") == false) return;
      const bookId = btn.getAttribute("id").split("-");
      let bookListArray = JSON.parse(localStorage.getItem("product"));

      bookListArray.filter(
        (product) => product.id == bookId[1]
      )[0].isDeleted = true;

      deletedBook++;
      totalPage = Math.ceil((bookListArray.length - deletedBook) / bookPerPage);
      localStorage.setItem("product", JSON.stringify(bookListArray));
      insertBookSection(main);
      displayContentBook();
    });
  });
};

const manipulateBookInfo = (book) => {  

  const handleEnterKey = (e) => {
    if (e.key == "Enter") {
      confirmManipulate.click();
    }
  };
  document.addEventListener("keydown", handleEnterKey);
  let bookListArray = JSON.parse(localStorage.getItem("product"));
  const confirmManipulate = document.querySelector(".manipulate_confirm");
  const manipulateImageInput = document.querySelector(
    ".manipulate-image_input"
  );
  const manipulateNameInput = document.querySelector(".manipulate-name_input");
  const manipulateAuthorInput = document.querySelector(
    ".manipulate-author_input"
  );
  const manipulateTypeSelect = document.querySelector(
    ".manipulate-type_select"
  );
  const manipulateRatingSelect = document.querySelector(
    ".manipulate-rating_select"
  );
  const manipulatePriceInput = document.querySelector(
    ".manipulate-price_input"
  );
  let selectType = null;
  let selectRating = null;
  let inputFile = null;
  manipulateImageInput.addEventListener("change", (event) => {
    const selectedFile = event.target.files[0];
    if (selectedFile) {
      const reader = new FileReader();
      reader.onload = function (event) {
        inputFile = event.target.result;
        if (inputFile) {
          document.querySelector(".manipulate-image_new").src = inputFile;
        }
      };
      reader.readAsDataURL(selectedFile);
    } else {
      return;
    }
  });

  manipulateRatingSelect.addEventListener("change", () => {
    selectRating = manipulateRatingSelect.value;
  });
  manipulateTypeSelect.addEventListener("change", () => {
    selectType = manipulateTypeSelect.value;
  });

  confirmManipulate.addEventListener("click", () => {
    const bookImg = inputFile || book.url;  
    const bookName = manipulateNameInput.value || book.name;
    const bookAuthor = manipulateAuthorInput.value || book.author;
    const bookType = selectType || book.type;
    const bookRating = selectRating || book.rating;
    const bookPrice = manipulatePriceInput.value || book.price;
    let changeBookInfo = bookListArray.find((books) => books.id === book.id);
    changeBookInfo.url = bookImg;
    changeBookInfo.name = bookName;
    changeBookInfo.author = bookAuthor;
    changeBookInfo.type = bookType;
    changeBookInfo.price = bookPrice;
    changeBookInfo.rating = bookRating;
    if (/^\d*$/.test(manipulatePriceInput)) {
      window.alert("Price only contain number");
      manipulatePriceInput.value = "";
    } else {
      document.removeEventListener("keydown", handleEnterKey);
      localStorage.setItem("product", JSON.stringify(bookListArray));
      window.alert("Book info has been changed!");
      toggleHidden(layout);
      toggleHidden(containerManipulateDetail);
      containerManipulateDetail.remove();
      insertBookSection(main);
    }
    //sau khi da confirm thi dong div manipulate detail va cap nhat thong tin
  });
};

const closeProductManipulateDetail = () => {
  const containerManipulateDetailClose = document.querySelector(
    ".btn-manipulate_close"
  );

  if (containerManipulateDetail != null) {
    layout.onclick = (event) => {
      toggleHidden(containerManipulateDetail);
      containerManipulateDetail.remove();
    };
  }

  containerManipulateDetailClose.addEventListener("click", () => {
    toggleHidden(layout);
    toggleHidden(containerManipulateDetail);
  });
};

const openProductManipulateDetail = (btn) => {
  let bookListArray = JSON.parse(localStorage.getItem("product"));
  const btnId = parseInt(btn.getAttribute("id").split("-")[1]);
  const book = bookListArray.find((bookToFind) => bookToFind.id == btnId);
  const html = `
    <article class="manipulate-detail">
      <button class="btn-manipulate_close">
        <i class="fa-solid fa-x"></i>
      </button>
      <section class="manipulate-image_container">
        <img src="${
          book.url
        }" alt="" width="180px" height="300px" class="manipulate-image_old"/>
        <img src="Img/blank_img.png" alt="" width="180px" height="300px" class="manipulate-image_new" />
      </section>
      <section class="manipulate-input_container">
        <label>Image:</label>
        <input type="file" name="" class="manipulate-image_input" />
        <label>Name:</label>
        <input type="text" placeholder="${
          book.name
        }" class="manipulate-name_input"/>
        <label>Author:</label>
        <input type="text" placeholder="${
          book.author
        }" class="manipulate-author_input" />
        <label>Type:</label>
        <select class="manipulate-type_select">
          <option value="english">English</option>
          <option value="psychology">Psychology</option>
          <option value="chinese">Chinese</option>
          <option value="japanese">Japanese</option>
          <option value="manga">Manga</option>
          <option value="finance">Finance</option>
        </select>
        <label>Rating:</label>
        <select class="manipulate-rating_select">
        <option value="1">1</option>
        <option value="2">2</option>
        <option value="3">3</option>
        <option value="4">4</option>
        <option value="5">5</option>
      </select>
        <label>Price:</label>
        <input type="text" placeholder="${formatTotal(
          book.price
        )}&#8363;" class="manipulate-price_input" />
      </section>
      <button class="manipulate_confirm" id="${
        book.id
      }"><i class="fa-solid fa-check"></i></button>
    </article>
    
  `;

  main.insertAdjacentHTML("afterbegin", html);
  containerManipulateDetail = document.querySelector(".manipulate-detail");
  toggleHidden(layout);
  return book; //Khi bat div chinh sua sach len thi return ve cuon sach de cho viec thay doi thong tin sach trong bookFile
};

const toggleProductManipulateDetail = (btn) => {
  const book = openProductManipulateDetail(btn);
  manipulateBookInfo(book);
  closeProductManipulateDetail();
};

const addManipulateEvent = () => {
  btnManipulateProductList.forEach((btn) => {
    btn.addEventListener("click", () => {
      toggleProductManipulateDetail(btn);
    });
  });
};

const openManipulateAdd = () => {
  const addManipulateHtml = `
  <article class="manipulate-add_container">
  <button class="btn-add_close">
    <i class="fa-solid fa-x"></i>
  </button>
    <img src="Img/blank_img.png" alt="" width="180px" height="280px" class="manipulate-add_image" />
  </section>
  <section class="add-input_container">
    <label>Image:</label>
    <input type="file" name="" class="add-image_input" class="add-file_input" />
    <label>Name:</label>
    <input type="text" placeholder="Ex: Harry Potter" class="add-name_input"/>
    <label>Author:</label>
    <input type="text" placeholder="Ex: J.K.Rowling" class="add-author_input" />
    <label>Type:</label>
    <select class="add-type_select">
      <option value="english">English</option>
      <option value="psychology">Psychology</option>
      <option value="chinese">Chinese</option>
      <option value="japanese">Japanese</option>
      <option value="manga">Manga</option>
      <option value="finance">Finance</option>
    </select>
    <label>Rating:</label>
    <select class="add-rating_select">
    <option value="1">1</option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
  </select>
    <label>Price:</label>
    <input type="text" placeholder="123(.000&#8363;)" class="add-price_input" />
  </section>
  <button class="btn-add_confirm" id="book-id"><i class="fa-solid fa-check"></i></button>
</article>
  `;
  main.insertAdjacentHTML("beforeend", addManipulateHtml);
  containerManipulateAdd = document.querySelector(".manipulate-add_container");

  manipulateAddImage = document.querySelector(".manipulate-add_image");
  btnAddClose = document.querySelector(".btn-add_close");
  addBookNameInput = document.querySelector(".add-name_input");
  addBookAuthorInput = document.querySelector(".add-author_input");
  addBookPriceInput = document.querySelector(".add-price_input");
  addBookFileInput = document.querySelector(".add-image_input");
  addBookTypeSelect = document.querySelector(".add-type_select");
  addBookRatingSelect = document.querySelector(".add-rating_select");
  btnAddBookConfirm = document.querySelector(".btn-add_confirm");

  toggleHidden(layout);
};

const closeManipulateAdd = () => {
  if (containerManipulateAdd != null) {
    layout.onclick = (event) => {
      console.log(24111);
      toggleHidden(containerManipulateAdd);
      containerManipulateAdd.remove();
    };
  }

  btnAddClose.addEventListener("click", () => {
    toggleHidden(layout);
    containerManipulateAdd.remove();
  });
};

const addBookToListEvent = () => {
  const handleEnterKey = (e) => {

    if (e.key == "Enter") {
      btnAddBookConfirm.click();
    }
  };
  document.addEventListener("keydown", handleEnterKey);
  let inputFile = null;
  let selectRating = addBookRatingSelect.value;
  let selectType = addBookTypeSelect.value;
  addBookFileInput.addEventListener("change", (event) => {
    const selectedFile = event.target.files[0];
    if (selectedFile) {
      const reader = new FileReader();
      reader.onload = function (event) {
        inputFile = event.target.result;
        if (inputFile) {
          manipulateAddImage.src = inputFile;
        }
      };

      reader.readAsDataURL(selectedFile);
    } else {
      return;
    }
  });
  addBookRatingSelect.addEventListener("change", () => {
    selectRating = addBookRatingSelect.value;
  });
  addBookTypeSelect.addEventListener("change", () => {
    selectType = addBookTypeSelect.value;
  });
  btnAddBookConfirm.addEventListener("click", () => {
    let bookListArray = JSON.parse(localStorage.getItem("product"));
    const bookName = addBookNameInput.value;
    const bookPrice = parseInt(addBookPriceInput.value);
    const bookAuthor = addBookPriceInput.value;
    const bookImage = inputFile;
    const bookType = selectType;
    const bookRating = selectRating;
    let containLetter = /^\d*$/.test(bookPrice);
    let message = "";
    if (
      bookName &&
      bookAuthor &&
      bookPrice &&
      bookImage &&
      bookType &&
      bookRating
    ) {
      let book = {
        name: bookName,
        price: bookPrice,
        author: bookAuthor,
        url: bookImage,
        type: bookType,
        rating: bookRating,
        id: 0,
      };

      book.id = bookListArray.length;
      bookListArray.unshift(book);
      containerManipulateAdd.remove();
      document.removeEventListener("keydown", handleEnterKey);
      toggleHidden(containerManipulateAdd);
      toggleHidden(layout);
      localStorage.setItem("product", JSON.stringify(bookListArray));
      containerManipulateAdd.remove();
      insertBookSection(main);
      message = "Added new book to File~";
    } else if (!containLetter) {
      message = "Price only contain number";
    } else if (
      !bookName ||
      !bookAuthor ||
      !bookPrice ||
      !bookImage ||
      !bookType ||
      !bookRating
    ) {
      message = "Must fill all book information";
    }
    window.alert(message);
  });
};

const manipulateAddBook = () => {
  btnManipulateAdd.addEventListener("click", () => {
    openManipulateAdd();
    addBookToListEvent();
    closeManipulateAdd();
  });
};

const orderStatus = (status) => {
  if (status == 0) return "Chưa Xử Lý";
  if (status == 1) return "Đã Xác Nhận";
  if (status == 2) return "Đơn Bị Từ Chối";
};

const orderStatusStyle = (status) => {
  if (status == 0) return "gold";
  else if (status == 1) return "#00d664";
  else return "#f53b57";
};

const toggleSortStatus = (element) => {
  if (element.classList.contains("down")) {
    element.classList.remove("down");
    element.classList.add("up");
  } else {
    element.classList.remove("up");
    element.classList.add("down");
  }
};

const insertOrderSection = () => {
  adminMode = 2;
  const orderSectionHtml = ` <section class="admin-order_container">
  <section class="order-date_container"><label style="display:inline-block;"> Lọc đơn theo ngày: &nbsp; &nbsp;</label><input type="date" class="input-sort_date"></section>
  <table class="manage-order_table">
    <thead>
      <tr>
        <th class="order-section_heading">User ID</th>
        <th class="order-section_heading">Order ID</th>
        <th class="order-section_heading">Order Date</th>
        <th class="order-section_heading">Total Money</th>
        <th class="order-section_heading">Status</th>
      </tr>
    </thead>
    <tbody class="order-section">
      
      </tbody>
  </table>
  </section>
  <div class="admin-sort_container">
  <button class="btn-sort_icon btn-admin"><i class="fa-solid fa-sort"></i></button>
  <button class="btn-sort_user btn-admin" title="Sort by user Id"><i class="fa-solid fa-person-arrow-down-to-line"></i></button>
  <button class="btn-sort_amount btn-admin" title="Sort by amount"><i class="fa-solid fa-sort-amount-down"></i></button>
  <button class="btn-sort_order btn-admin" title="Sort by order Id"><i class="fa-solid fa-arrow-down-9-1"></i></button>
  <button class="btn-sort_confirm btn-admin" title="View confirmed order"><i class="fa-solid fa-check"></i></button>
  <button class="btn-sort_decline btn-admin" title="View declined order"><i class="fa-regular fa-circle-xmark"></i></button>
  <button class="btn-sort_pending btn-admin" title="View pending order"><i class="fa-solid fa-ellipsis"></i></button>
  </div>`;
  main.innerHTML = orderSectionHtml;
  containerOrderSection = document.querySelector(".order-section");
  btnSortUser = document.querySelector(".btn-sort_user");
  btnSortOrder = document.querySelector(".btn-sort_order");
  btnSortAmount = document.querySelector(".btn-sort_amount");
  btnSortConfirm = document.querySelector(".btn-sort_confirm");
  btnSortDecline = document.querySelector(".btn-sort_decline");
  btnSortPending = document.querySelector(".btn-sort_pending");
  inputSortDate = document.querySelector(".input-sort_date");
  addBlurEvent();

  insertOrderData();
  orderSortEvent();
  headerAdmin();
};

const insertOrderData = (orderlist) => {
  let orderArray = JSON.parse(localStorage.getItem("orderCustomer"));
  let orderDataHtml = " ";
  if (orderlist) {
    orderlist.forEach((order) => {
      orderDataHtml += `
      <tr class="order-data" id="order-${order.id}">
      <td class="data-user_id">Cus${order.accCustomer.id}</td>
      <td class="data-order_id">Ord${order.id}</td>
      <td class="data-order_date">${order.dateOrder}</td>
      <td class="data-order_total">${formatTotal(order.totalPrice)}&#x20AB;</td>
      <td  class="data-order_status" style="color:${orderStatusStyle(
        order.status
      )}">${orderStatus(order.status)}</td>
    </tr>`;
    });
  } else {
    orderArray.forEach((order) => {
      orderDataHtml += `
      <tr class="order-data" id="order-${order.id}">
      <td class="data-user_id">Cus${order.accCustomer.id}</td>
      <td class="data-order_id">Ord${order.id}</td>
      <td class="data-order_date">${order.dateOrder}</td>
      <td class="data-order_total">${formatTotal(order.totalPrice)}&#x20AB;</td>
      <td  class="data-order_status" style="color:${orderStatusStyle(
        order.status
      )}">${orderStatus(order.status)}</td>
    </tr>`;
    });
  }
  containerOrderSection.innerHTML = orderDataHtml;
  btnOrderDataList = document.querySelectorAll(".order-data");
  addOrderDetailEvent();
};

const openOrderDetail = (orderData) => {
  const orderId = parseInt(orderData.getAttribute("id").split("-")[1]);
  const order = JSON.parse(localStorage.getItem("orderCustomer")).find(
    (orderToFind) => orderToFind.id == orderId
  );
  const detailHtml = `
  <div class="order-detail" id="order-${order.id}">
  <button class="btn-order_close"><i class="fa-solid fa-x"></i></button>
  <p class="order-label"><strong>User Id</p></strong>
  <p class="order-user_id">${order.accCustomer.id}</p>
  <p class="order-label"><strong>Order Id</p></strong>
  <p class="order-order_id">${order.id}</p>
  <p class="order-label"><strong>Order info: </p></strong>
  <p class="order-info">${order.orderBook}</p>
  <p class="order-label"><strong>Order date</p></strong>
  <p class="order-date">${order.dateOrder}</p>
  <p class="order-label"><strong>Address</p></strong>
  <p order-address>${order.address}</p>
  <p class="order-label"><strong>Total</p></strong>
  <p class="order-total">${order.totalPrice}&#x20AB;</p>
  <p class="order-label"><strong>Status</strong></p>
  <p class="order-status" style="color:${orderStatusStyle(
    order.status
  )}">${orderStatus(order.status)}</p>
  <div class="btn-order_container">
  <button class="btn-order_decline">Decline</button>
  <button class="btn-order_confirm">Confirm</button>
</div>
  `;
  main.insertAdjacentHTML("beforeend", detailHtml);
  containerOrderDetail = document.querySelector(".order-detail");
  btnOrderClose = document.querySelector(".btn-order_close");
  btnOrderConfirm = document.querySelector(".btn-order_confirm");
  btnOrderDecline = document.querySelector(".btn-order_decline");
  validateOrderEvent(order);
  toggleHidden(layout);
};

const closeOrderDetail = () => {
  if (adminMode == 2) {
    layout.onclick = () => {
      toggleHidden(containerOrderDetail);
      containerOrderDetail.remove();
      return;
    };

    btnOrderClose.addEventListener("click", () => {
      toggleHidden(layout);
      toggleHidden(containerOrderDetail);
      containerOrderDetail.remove();
    });
  }
};

const validateOrderEvent = (order) => {
  let orderListArray = JSON.parse(localStorage.getItem("orderCustomer"));
  btnOrderConfirm.addEventListener("click", () => {
    const index = orderListArray.findIndex((o) => o.id == order.id);
    orderListArray[index].status = 1;
    toggleHidden(layout);
    toggleHidden(containerOrderDetail);
    containerOrderDetail.remove();
    localStorage.setItem("orderCustomer", JSON.stringify(orderListArray));
    insertOrderSection();
  });
  btnOrderDecline.addEventListener("click", () => {
    const index = orderListArray.findIndex((o) => o.id == order.id);
    orderListArray[index].status = 2;
    toggleHidden(layout);
    toggleHidden(containerOrderDetail);
    containerOrderDetail.remove();
    localStorage.setItem("orderCustomer", JSON.stringify(orderListArray));
    insertOrderSection();
  });
};

const addOrderDetailEvent = () => {
  btnOrderDataList.forEach((btn) => {
    btn.addEventListener("click", () => {
      openOrderDetail(btn);
      closeOrderDetail();
    });
  });
};

const orderSortEvent = () => {
  let orderListArray = JSON.parse(localStorage.getItem("orderCustomer"));
  btnSortUser.addEventListener("click", () => {
    const orderListSort = orderListArray.slice();
    if (btnSortUser.classList.contains("down")) {
      orderListSort.sort(
        (ordA, ordB) => ordB.accCustomer.id - ordA.accCustomer.id
      );
      btnSortUser.innerHTML = `<i class="fa-solid fa-person-arrow-down-to-line"></i>`;

      toggleSortStatus(btnSortUser);
    } else {
      orderListSort.sort(
        (ordA, ordB) => ordA.accCustomer.id - ordB.accCustomer.id
      );
      btnSortUser.innerHTML = `<i class="fa-solid fa-person-arrow-up-from-line"></i>`;
      toggleSortStatus(btnSortUser);
    }
    localStorage.setItem("orderCustomer", JSON.stringify(orderListSort));
    insertOrderData(orderListSort);
  });
  inputSortDate.addEventListener("change", () => {
    const date = inputSortDate.value;
    const orderListSort = orderListArray.slice().filter((ord) => {
      const [day, month, year] = ord.dateOrder.split("/");
      return new Date(year, month - 1, day) - new Date(date) > 0;
    });

    insertOrderData(orderListSort);
  });
  btnSortOrder.addEventListener("click", () => {
    const orderListSort = orderListArray.slice();
    if (btnSortOrder.classList.contains("down")) {
      orderListSort.sort((ordA, ordB) => ordB.id - ordA.id);
      btnSortOrder.innerHTML = `<i class="fa-solid fa-arrow-down-9-1"></i>`;
      toggleSortStatus(btnSortOrder);
    } else {
      orderListSort.sort((ordA, ordB) => ordA.id - ordB.id);
      btnSortOrder.innerHTML = `<i class="fa-solid fa-arrow-up-1-9"></i>`;
      toggleSortStatus(btnSortOrder);
    }
    localStorage.setItem("orderCustomer", JSON.stringify(orderListSort));
    insertOrderData(orderListSort);
  });
  btnSortAmount.addEventListener("click", () => {
    const orderListSort = orderListArray.slice();

    if (btnSortAmount.classList.contains("down")) {
      orderListSort.sort((ordA, ordB) => ordB.totalPrice - ordA.totalPrice);
      btnSortAmount.innerHTML = `<i class="fa-solid fa-arrow-down-wide-short"></i>`;
      toggleSortStatus(btnSortAmount);
    } else {
      orderListSort.sort((ordA, ordB) => ordA.totalPrice - ordB.totalPrice);
      btnSortAmount.innerHTML = `<i class="fa-solid fa-arrow-up-short-wide"></i>`;
      toggleSortStatus(btnSortAmount);
    }
    localStorage.setItem("orderCustomer", JSON.stringify(orderListSort));
    insertOrderData(orderListSort);
  });
  btnSortConfirm.addEventListener("click", () => {
    const orderListSort = new Array();
    orderListArray.forEach((order) => {
      if (order.status == 1) orderListSort.push(order);
    });
    insertOrderData(orderListSort);
  });
  btnSortDecline.addEventListener("click", () => {
    const orderListSort = new Array();
    orderListArray.forEach((order) => {
      if (order.status == 2) orderListSort.push(order);
    });
    insertOrderData(orderListSort);
  });
  btnSortPending.addEventListener("click", () => {
    const orderListSort = new Array();
    orderListArray.forEach((order) => {
      if (order.status == 0) orderListSort.push(order);
    });
    insertOrderData(orderListSort);
  });
};

const calcTotalSpent = (userId) => {
  let orderListArray = JSON.parse(localStorage.getItem("orderCustomer"));
  let total = orderListArray.reduce((accumulator, order) => {
    if (order.accCustomer.id == userId) {
      accumulator += order.totalPrice;
    }
    return accumulator;
  }, 0);
  return total;
};

const insertUserSection = () => {
  adminMode = 3;
  const userSectionHtml = `  <section class="admin-user_container">
  <table class="manage-user_table">
    <thead>
      <tr>
        <th class="user-section_heading">User Id</th>
        <th class="user-section_heading">Username</th>
        <th class="user-section_heading">Total Spent</th>
        <th class="user-section_heading">Join Date</th>
        <th class="user-section_heading">Delete User</th>
      </tr>
    </thead>
    <tbody class="user-section">
      </tbody>
  </table>
</section>`;
  main.innerHTML = userSectionHtml;
  containerUserSection = document.querySelector(".user-section");
  insertUserData();
  deleteUserEvent();
  headerAdmin();
};

const insertUserData = () => {
  let userListArray = JSON.parse(localStorage.getItem("user"));
  userListArray.forEach((user) => {
    if (user.isDeleted) return;
    const userDataHtml = `
    <tr class="user-data">
          <td class="user-data_id">${user.id}</td>
          <td class="user-data_username">${user.username}</td>
          <td class="user-data_total">${formatTotal(
            calcTotalSpent(user.id)
          )}</td>
          <td class="user-data_date">${user.dateSignUp}</td>
          <td class="user-data_button" id="user-${user.id}">
            <button class="user-data_delete" ><i class="fa-solid fa-user-slash"></i></button>
          </td>
    </tr>
    `;
    containerUserSection.insertAdjacentHTML("beforeend", userDataHtml);
  });
  btnDeleteUserList = document.querySelectorAll(".user-data_button");
};

const deleteUserEvent = () => {
  let userListArray = JSON.parse(localStorage.getItem("user"));
  btnDeleteUserList.forEach((btn) => {
    btn.addEventListener("click", () => {
      let result = window.confirm("Confirm delete user?");
      if (!result) return;
      const userId = parseInt(btn.getAttribute("id").split("-")[1]);
      console.log(userId);
      if (userId != 1) {
        const userDelete = userListArray.find((user) => user.id == userId);
        if (userDelete) {
          userDelete.isDeleted = true;
          localStorage.setItem("user", JSON.stringify(userListArray));
          insertUserSection();
        }
      } else {
        alert("Admin không thể tự xóa chính mình !!!!");
      }
    });
  });
};

const insertStatisticSection = () => {
  const statisticSectionHtml = `
  <section class="admin-statistic_container">
    <table class="statistic-product_table">
      <thead>
        <tr>
          <th class="statistic-section_heading">Book Id</th>
          <th class="statistic-section_heading">Book name</th>
          <th class="statistic-section_heading">Type</th>
          <th class="statistic-section_heading">Quantity Sold</th>
        </tr>
      </thead>
      <tbody class="statistic-section">

      </tbody>
    </table>
    <p class="statistic-p">Tổng sản phẩm đã bán: <span class="statistic-sold statistic-label"></span></p>
    <p class="statistic-p">Tổng doanh thu: <span class="statistic-revenue statistic-label"</p>
  </section>
  <button class="btn-statistic_chart btn-statistic btn-admin"><i class="fa-solid fa-chart-simple"></i></button>`;
  main.innerHTML = statisticSectionHtml;
  containerStatisticSection = document.querySelector(".statistic-section");
  statisticRevenueLabel = document.querySelector(".statistic-revenue");
  statisticSoldLabel = document.querySelector(".statistic-sold");
  btnStatistic = document.querySelector(".btn-statistic");
  addBtnStatisticEvent();
  addBlurEvent();
  insertStatisticData();
  headerAdmin();
};

const insertStatisticData = () => {
    let orderListArray = JSON.parse(localStorage.getItem("orderCustomer"));
    const bookCountMap = new Map();
    totalRevenue = 0;
    totalSold = 0;
    orderListArray.forEach((order) => {
      if ( order.status==1)
      {
        order.bookArr.forEach((book) => {
          const { id, quantity, name, type, price } = book;

          if (bookCountMap.has(id)) {
            bookCountMap.set(id, {
              count:parseInt(bookCountMap.get(id).count)+parseInt(quantity),name,type,price
            });
            console.log(bookCountMap.get(id));
          } 
          else {
            bookCountMap.set(id, { count: quantity, name, type, price });
          }
        });
      }
      //chuyen doi thanh map de de su dung
    });

    bookCountArray = [...bookCountMap].map(([id, details]) => ({
      id,
      count: details.count,
      name: details.name,
      type: details.type,
      price: details.price,
    }));
    let bookTdHtml = "";
    const bookTempArr = [...bookCountArray].sort((a, b) => b.count - a.count);
    bookTempArr.forEach((book) => {
      bookTdHtml += ` <tr class="statistic-data">
  <td class="statistic-data_id">${book.id}</td>
  <td class="statistic-data_name">${book.name}</td>
  <td class="statistic-data_type">${book.type}</td>
  <td class="statistic-data_count">${book.count}</td>
  </tr>`;
      totalSold += parseInt(book.count);
      totalRevenue+= parseInt(book.count)*parseInt(book.price);
    });
    statisticSoldLabel.textContent = totalSold;
    statisticRevenueLabel.textContent = formatTotal(totalRevenue);
    containerStatisticSection.innerHTML = bookTdHtml;
};

const loadChartJsAndRender = () => {
  const chartJsScript = document.createElement("script");
  chartJsScript.src = "https://cdn.jsdelivr.net/npm/chart.js";
  document.head.appendChild(chartJsScript);

  chartJsScript.onload = () => {
    const chartJsPluginScript = document.createElement("script");
    chartJsPluginScript.src =
      "https://cdn.jsdelivr.net/npm/chartjs-plugin-datalabels@2.0.0";
    document.head.appendChild(chartJsPluginScript);
    chartJsPluginScript.onload = () => {
      renderChartSection();
    };
  };
};

const renderChartSection = () => {
  main.innerHTML = `<section class="admin-chart_container " ><canvas id="bookStatisticChart"></canvas></section>
  <button class="btn-statistic btn-statistic_table btn-admin"><i class="fa-solid fa-table"></i></button>`;
  btnStatistic = document.querySelector(".btn-statistic");
  addBtnStatisticEvent();
  createChart();
};

const createChart = () => {
  let psychology = 0;
  let chinese = 0;
  let finance = 0;
  let japanese = 0;
  let manga = 0;
  let english = 0;
  const xValue = [
    "Psychology",
    "Chinese",
    "Finance",
    "Japanese",
    "Manga",
    "English",
  ];
  const barColors = ["red", "green", "blue", "orange", "yellow", "brown"];
  bookCountArray.forEach((book) => {
    switch (book.type) {
      case "Psychology":
        psychology += parseInt(book.count);
        break;
      case "Chinese":
        chinese += parseInt(book.count);
        break;
      case "Finance":
        finance += parseInt(book.count);
        break;
      case "Japanese":
        japanese += parseInt(book.count);
        break;
      case "Manga":
        manga += parseInt(book.count);
        break;
      case "English":
        english += parseInt(book.count);
        break;
      default:
        break;
    }
  });

  new Chart("bookStatisticChart", {
    type: "bar",
    data: {
      labels: xValue,
      datasets: [
        {
          label: "",
          backgroundColor: barColors,
          data: [psychology, chinese, finance, japanese, manga, english],
        },
      ],
    },
    plugins: [ChartDataLabels],
    options: {
      plugins: {
        title: {
          display: true,
          text: "Product Type Analysis",
          font: {
            size: 20,
          },
        },
        datalabels: {
          color: "black",
          font: {
            weight: "bolder",
            size: 16,
          },
          anchor: "end",
          align: "top",
          legend: { display: false },
        },
      },
      responsive: true,
      maintainAspectRatio: false,
    },
  });
};

const addBlurEvent=()=>{
  let btnList=document.querySelectorAll('button');
  btnList.forEach((btn)=>{
    btn.addEventListener("click",()=>{
      btn.blur();
    })
  })
}
const addBtnStatisticEvent = () => {
  btnStatistic.addEventListener("click", () => {
    if (btnStatistic.classList.contains("btn-statistic_chart")) {
      loadChartJsAndRender();
    } else if (btnStatistic.classList.contains("btn-statistic_table")) {
      insertStatisticSection();
    }
  });
};

const addNavigationAdminEvent = () => {
  addBlurEvent()
  btnNavigationStatistic.addEventListener("click", insertStatisticSection);
  btnNavigationOrder.addEventListener("click", insertOrderSection);
  btnNavigationProduct.addEventListener("click", () => {
    adminMode = 1; //Cap nhat trang thai dang o mode sua sach
    insertBookSection(main); //Them vao book section
  });
  btnNavigationUser.addEventListener("click", insertUserSection);
};

addNavigationAdminEvent();
