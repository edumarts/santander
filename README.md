# santander
Run app
java -jar client-admin-0.0.1-SNAPSHOT.jar

List all clients
curl --Header "DATA: fb48b5619accfdb6ef9315560e0fff8a9c927ad39986241b55558f57efbd3529" localhost:8000/client/get-all

Get client with id = 6
curl --Header "DATA: fb48b5619accfdb6ef9315560e0fff8a9c927ad39986241b55558f57efbd3529" localhost:8000/client/6

Add new client
curl --Header "DATA: fb48b5619accfdb6ef9315560e0fff8a9c927ad39986241b55558f57efbd3529" -X POST -d nombre=AntonioJuan -d apellidoPaterno=Salinas -d apellidoMaterno=Hernandez -d fechaNacimiento=1981/04/02 -d rfc=ANSH810402333 -d numeroCelular=5654451236 -d email=asalinas@santander.com localhost:8000/client

Update cliente
curl --Header "DATA: fb48b5619accfdb6ef9315560e0fff8a9c927ad39986241b55558f57efbd3529" -X PUT -d id=1 -d nombre=Juan -d apellidoPaterno=Perez -d apellidoMaterno=Hernandez -d fechaNacimiento=1981/04/02 -d rfc=JUPH800402185 -d numeroCelular=5654451234 -d email=asalinas@santander.com localhost:8000/client

Delete client
curl --Header "DATA: fb48b5619accfdb6ef9315560e0fff8a9c927ad39986241b55558f57efbd3529" -X DELETE localhost:8000/client/1
