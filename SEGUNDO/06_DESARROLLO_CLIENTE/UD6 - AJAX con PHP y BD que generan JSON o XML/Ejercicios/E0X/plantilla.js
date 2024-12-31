	
	function () {
	//    0 No inicializado.    1 Cargando.    2 Cargado.    3 Interactivo.    4 Completado.
		if(peticio_http.readyState == 4) {
			if(peticio_http.status == 200) {  //si tot OK
			
			}
			else{  //mostra el estat en format de text
				alert("error: "+peticio_http.statusText);
			}			
		}
	}	

	function (event) {
		// Obtener  instancia objete XMLHttpRequest

		peticio_http = new XMLHttpRequest();


		// Prepara funcio rep dades del servidor
		peticio_http.onreadystatechange = ;

		peticio_http.open('', '', true);
		//indiquem que les dades estan codificades com un formulari
		//peticio_http.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		//comence el proces. envies les dades
		peticio_http.send(); 

	}


