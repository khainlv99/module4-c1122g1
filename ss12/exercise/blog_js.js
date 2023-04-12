// load Blog
function loadMore(nextPage) {
  loadBlogs(nextPage, true);
}

function renderLoadMoreBtn(blogPageData) {
  if (blogPageData.number < blogPageData.totalPages - 1) {
    $("#loadMoreContainer").html(
      `
                <button id="loadMoreId" type="button" class="btn btn-primary"
                onclick="loadMore(${blogPageData.number + 1})">
                Load More
                </button>
            `
    );
  } else {
    $("#loadMoreId").remove();
  }
}

function getBlogInfo(id, name) {
  document.getElementById("deleteId").value = id;
  document.getElementById("deleteName").innerText = "Xóa blog " + name;
}

function renderBlogs(blogs, append) {
  let elements = "";
  for (let blog of blogs) {
    elements += `<tr>
        <td>${blog.authorName}</td>
        <td>${blog.title}</td>
        <td>${blog.categoryDTO.name}</td>
        <td>
            <button type="button" class="btn btn-danger" data-bs-toggle="modal" data-bs-target="#exampleModal""
                onclick="getBlogInfo(${blog.id}, '${blog.title}')">
                Delete
            </button>
        </td>
        </tr>`;
  }
  if (append) {
    $("#listBlogs").append(elements);
  } else {
    $("#listBlogs").html(elements);
  }
}

function loadBlogs(page, append) {
  let title = $("#title").val();
  $.ajax({
    type: "GET",
    url: `http://localhost:8080/blog?page=${page ? page : "0"}&title=${title}`,
    headers: {
      "Content-Type": "application/json",
    },
    success: function (data) {
      renderBlogs(data.content, append);
      renderLoadMoreBtn(data);
    },
    error: function (error) {
      console.log(error);
    },
  });
}

$(document).ready(function () {
  loadBlogs();
});

// delete Blog

$("#delete-blog").submit(function (event) {
  event.preventDefault();
  let id = $("#deleteId").val();
  deleteBlog(id);
});

function deleteBlog(id) {
  $.ajax({
    type: "delete",
    url: `http://localhost:8080/blog/${id}`,
    success: function (data) {
      console.log("Xóa thành công");
      loadBlogs();
    },
    error: function (error) {
      console.log("Lỗi, không xóa được");
    },
  });
}

$(document).ready(function () {
    deleteBlog();
});