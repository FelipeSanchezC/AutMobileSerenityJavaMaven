Feature: realizar login en el App de advate Shopping
  Yo como automatizador
  Quiero realizar flujos de Login en el app
  Para validar el correcto funcionamiento


  @test
  Scenario: Realizar  login exitoso en el App de forma correcta
    Given Me desplazo al menu del login
    When Ingreso Usuario con credenciales correctas
    Then Valido login exitoso