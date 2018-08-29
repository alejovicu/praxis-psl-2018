function hello () {
  $(document).ready(function () {
    $.ajax({
      url: 'http://localhost:3001/user'
    }).then(function (data) {
      $('#result').append(data.content)
    })
  })
}
