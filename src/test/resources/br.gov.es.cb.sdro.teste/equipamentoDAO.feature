Feature: Realizar calculos

Qualquer comentário que ajude a entender a funcionalidade
    
    Scenario: Somar dois numeros
        Given eu tenho o numero 1 e 2
        When eu quero somar
        Then Eu quero como resultado o numero 3
    
    Scenario: Test EquipamentoDAO
        Given eu tenho o objeto equipamento
        When eu quero remover
        Then eu quero como resultado o boolean true
    
    Scenario: Test ViaturaDAO
        Given eu tenho o objeto viatura
        When eu quero realocar
        Then eu quero como resultado o boolean true