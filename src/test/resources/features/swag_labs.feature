#language:en

Feature: Yo como usuario quiero probar el escenario de compra en el sitio Swag Labs

  @ComprarProducto
  Scenario Outline: Compra exitosa en el sitio
    Given el actor ingresa a saucedemo.com
      | url   |
      | <url> |
    When el actor se autentica con la siguiente informacion
      | usuario   | contrasena   |
      | <usuario> | <contrasena> |
    And agrega productos aleatorios al carrito y hace el checkout
      | nombre   | apellido   | zip   |
      | <nombre> | <apellido> | <zip> |
    Then valida que el producto se compro de manera exitosa y verifica los calculos
    Examples:
      | url                       | usuario       | contrasena   | mensajeExitoso            | nombre  | apellido | zip    |
      | https://www.saucedemo.com | standard_user | secret_sauce | Thank you for your order! | usuario | choucair | 470003 |

  @LoginFallido
  Scenario Outline: Inicio de sesión fallido con credenciales inválidas
    Given el actor ingresa a saucedemo.com
      | url                       |
      | <url>                     |
    When el actor intenta iniciar sesión con credenciales inválidas
      | usuario       | contrasena   |
      | <usuario>     | <contrasena> |
    Then el actor verifica que se muestra el mensaje de error "<mensajeError>"
    Examples:
      | url                       | usuario          | contrasena          | mensajeError                                                              |
      | https://www.saucedemo.com | usuario_invalido | contrasena_invalida | Epic sadface: Username and password do not match any user in this service |
      | https://www.saucedemo.com | locked_out_user  | secret_sauce        | Epic sadface: Sorry, this user has been locked out.                       |
