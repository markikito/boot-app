#¿Cómo consultar los datos con nuestra API REST?

###IDEs
Podemos usar varías:

- [PostMan](https://chrome.google.com/webstore/detail/postman/fhbjgbiflinjbdggehcddcbncdddomop)
- [Avanced Rest Client](https://chrome.google.com/webstore/detail/advanced-rest-client/hgmloofddffdnphfgcellkdfbfbjeloo)

###Opciones:

- Obtener nuestro token. *(Necesario para las peticiones POST)*
	```
	Conexion: POST
	URL: http://localhost:8080/api/login
	Body RAW: {"email": "hola@hola.es","password":"holahola"} Content-Type: application/json
	```
	Y en en el **'Headers'** nos dara nuestro **'x-auth-token'**

- Escribir un MicroPost

	```
	Conexion: POST
	URL: http://localhost:8080/api/microposts
	HEADER: x-auth-token = el token que hemos obtenido del headers en el paso anterior
			Content-Type = application/json
	Body RAW: {"email": "hola@hola.es","password":"holahola"} Content-Type: application/json
	```

- Obtener todos los MicroPost

	```
	Conexion: POST
	URL: http://localhost:8080/api/users/me/microposts
	HEADER: x-auth-token = el token que hemos obtenido del headers en el paso anterior
			Content-Type = application/json
	```

- Obtener los datos de un usuario

	```
	Conexion: GET
	URL: http://localhost:8080/api/users/1
	```
	*Recordatorio: Las conexiones tipo GET las podemos hacer desde el navegador*

Esto es un ejemplo de uso de la API REST, si ven alguna un poco más complicada que necesite explicación, sería bueno que la añadieran a este documento.
