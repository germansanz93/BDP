# Chain Of Responsibility
Este patron de diseño nos permite basicamente desacoplar el codigo que envia una peticion del codigo que la procesa.
Por lo general, el codigo que quiere que una solicitud sea procesada llama a un metodo exacto en un objeto exacto para que la procese. La cadena de responsabilidad soluciona este problema dando a mas de un objeto la chance de procesar el pedido.
Como efecto secundario de la aplicacion de este patron es que no tenemos la garantia de que finalmente la peticion sea procesada.

## Diagrama
´´´mermaid
classDiagram

class Client

Client..>Handler : use

class Handler
Handler: +handleRequest() void

Handler <-- Handler : +successor

class ConcreteHandlerA
ConcreteHandlerA: +handleRequest() void

class ConcreteHandlerB
ConcreteHandlerB: +handleRequest() void

Handler<|--ConcreteHandlerA
Handler<|--ConcreteHandlerB
´´´
