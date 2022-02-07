Feature: consulta de datos metereologicos para cualquier ubicacion en la tierra


  Scenario Outline: consultar el clima por ciudades en diferentes continentes
    Given un usuario que desea consultar el clima
    When el consulta los datos meteorologicos de la ciudad <City>
    Then obtiene el clima de la ciudad <City>
    Examples:
      | City     |
      | Paris    |
      | Bogota   |
      | Kabul    |
      | Dakar    |
      | Canberra |
      | Namekusein |


  Scenario Outline: Obtener la temperatura en diferente unidades
    Given un usuario que desea consultar el clima
    When el consulta los datos meteorologicos de la ciudad <City> en unidades <Units>
    Then obtiene el clima de la ciudad <City>
    Examples:
      | City   | Units      |
      | Paris  | Fahrenheit |
      | Bogota | Celsius    |
      | Kabul  | Kelvin     |
      | Dakar  | metros     |

  Scenario Outline: consultar el estado del clima por codigo de estado en USA
    Given un usuario que desea consultar el clima
    When el consulta los datos meteorologicos de la ciudad <City> en el <State> de USA
    Then obtiene el clima de la ciudad <City>
    Examples:
      | City       | State  |
      | Alaska     | 99501  |
      | California | 942003 |
      | Florida    | 32501  |
      | Georgia    | 30301  |

  Scenario Outline: Consultar el estado del clima por ciudad y pais
    Given un usuario que desea consultar el clima
    When el consulta los datos meteorologicos de la ciudad <City> en el pais <Country>
    Then obtiene el clima de la ciudad <City> en el pais <Country>
    Examples:
      | City   | Country      |
      | Bogota | CO           |
      | Bogota | USA          |


  Scenario Outline: Consultar el estado del clima por ciudad y sin pais
    Given un usuario que desea consultar el clima
    When el consulta los datos meteorologicos de la ciudad <City>
    Then obtiene el clima de la ciudad <City>
    Examples:
      | City   |
      | Bogota |

  Scenario Outline: Consultar el estado del clima por coordenadas geograficas
    Given un usuario que desea consultar el clima
    When el consulta los datos meteorologicos por coordenadas geograficas <Latitud> y <Longitud>
    Then obtiene el clima de la ciudad <City>
    Examples:
      | Latitud | Longitud | City     |
      | 35      | 139      | Shuzenji |
      | 10      | 234      | Bogota   |

  Scenario Outline: Consultar el estado del clima por codigo zip
    Given un usuario que desea consultar el clima
    When el consulta los datos meteorologicos por codigo <Zip>
    Then obtiene el clima de la ciudad <City>
    Examples:
      | Zip           | City         |
      | 83254         | Montpelier   |
      | 83254         | Bogota       |


  Scenario: Validacion tecnica del servicio de consulta
    Given un usuario que desea consultar el clima
    When el consulta los datos meteorologicos de la ciudad Bogota
    Then la validacion del jschema es satisfactoria











