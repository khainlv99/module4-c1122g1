$("#add-blog").submit(function (event) {
  debugger
  event.preventDefault();
  let authorName = $('#authorName').val();
  let title = $('#title').val();
  let content = $("#content").val();
  let category = $("#categoryValue").val();
  addProduct(authorName, title, content, category);
});

function addProduct(authorName, title, content, category) {
  debugger
  $.ajax({
    headers: {
      'Accept': 'application/json',
      'Content-Type': 'application/json'
    },
    url: "http://localhost:8080/blog",
    type: "POST",
    data: JSON.stringify({
      authorName: authorName,
      title: title,
      content: content,
      categoryDTO: {name:category},
    }),
    success: function (data) {
      alert("Thêm sản phẩm thành công!");
      window.location.replace("blog.html");
    },
    error: function () {
      alert("Lỗi khi thêm sản phẩm!");
    },
  });
}

function loadSelectCategories() {
  $.ajax({
    type: "GET",
    url: `http://localhost:8080/category/list`,
    headers: {
      "Content-Type": "application/json",
    },
    success: function (data) {
      showCategorySelectOption(data);
    },
    error: function (error) {
      console.log(error);
    },
  });
}

function showCategorySelectOption(categories) {
  let element = "";
  element += `
    <select class="form-control mb-3" id="categoryValue">`

  for (let category of categories) {
    element += `<option value="${category.name}">`
    element +=category.name ;
    `</option>`
  }

    `</select>`;
  $("#select-category").html(element);
}

$(document).ready(function () {
  loadSelectCategories();
});
