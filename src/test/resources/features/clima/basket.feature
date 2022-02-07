Feature: almacenamiento de estadistica del clima en un basket

  Scenario Outline: almacenar estadisticas del clima en un basket
    Given un usuario que tiene el reporte del clima de la ciudad <City> en el pais <Country>
    And posee la temperatura en grados celsius <TempC>
    And tambien la temperatura en grado Farhenheit <TempF>
    When el envia la peticion para almacenar los datos meteorologicos
    Then obtiene el guardado exitoso en un basket
    Examples:
      | Country  | City        | TempC   | TempF |
      | COLOMBIA | Bogota      | 20      | 12    |
      | VENEZUELA | CARACAS    | 25      | 4     |


  Scenario Outline: consultar estadisticas del clima en un basket
    Given un usuario que tiene el reporte del clima de la ciudad <City> en el pais <Country>
    And posee la temperatura en grados celsius <TempC>
    And tambien la temperatura en grado Farhenheit <TempF>
    When el envia la peticion para consultar los datos meteorologicos
    Then obtiene la informacion de los datos almacenados del clima
    Examples:
      | Country  | City        | TempC   | TempF |
      | COLOMBIA | Bogota      | 20      | 12    |
      | VENEZUELA | CARACAS    | 25      | 4     |



  Scenario Outline: Actualizar estadisticas del clima en un basket
    Given un usuario que tiene el reporte del clima de la ciudad <City> en el pais <Country>
    And posee la temperatura en grados celsius <TempC>
    And tambien la temperatura en grado Farhenheit <TempF>
    When el envia la peticion para actualizar los datos meteorologicos <TempCActual> y <TempFActual>
    Then obtiene la informacion de los datos actualizados del clima
    Examples:
      | Country  | City        | TempC   | TempF | TempCActual | TempFActual |
      | COLOMBIA | Bogota      | 20      | 12    |  30         | 50          |
      | VENEZUELA | CARACAS    | 25      | 4     |  35         | 55          |


  Scenario Outline: Eliminar estadisticas del clima en un basket
    Given un usuario que tiene el reporte del clima de la ciudad <City> en el pais <Country>
    And posee la temperatura en grados celsius <TempC>
    And tambien la temperatura en grado Farhenheit <TempF>
    When el envia la peticion para eliminar el registro
    Then los datos son eliminados del basket
    Examples:
      | Country  | City        | TempC   | TempF |
      | COLOMBIA | Bogota      | 20      | 12    |






