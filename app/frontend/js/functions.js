function inputListener () {
  const input = document.getElementById('txt-command');
  input.addEventListener('keyup', function(event) {
    event.preventDefault();
    if (event.keyCode === 13) {
      $('.btn').click();
    }
  });
}

function clearResults () {
  $( "#result" ).html( '' );
}

function buttonAction () {
  clearResults ();

  const command = $('#txt-command').val();

  if(command === null || command === '' || !command) {
   alert ('Comando vacío');
   return;
  }

  const commandArr = command.split(' ');

  switch(commandArr[0].toLowerCase()) { // it should check in lowercase
  case 'crear':
    $.get(
      'http://localhost:3001/user?command=crear&name='+commandArr[1],
      function( data ) {
      $( '#result' ).html( 'Registro creado ['+data[0].name+']' );
      }
    );
    break;
  case 'mostrar':
    $.get(
      'http://localhost:3001/user?command=mostrar',
      function( data ) {
        $('#result').append('<h2 class=\'text-center result result-header\'>Resultados</h2>');
        data.forEach(({name: n}) => $('#result').append('<p class=\'text-center result result-row\'>'+n+'</p>'));

      }
    );
    break;
  default:
    alert ('Error: Comando no válido: ' + commandArr[0]);
  }

  /*
  $.get( "http://localhost:3001/user", function( data ) {
    $( "#result" ).html( data[0].name );
  });*/

  $('#txt-command').val('');
}
