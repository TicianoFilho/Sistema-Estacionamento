# Projeto de Controle de Estacionamento

## Tecnologias usadas: Java, Spring Boot, Spring Data JPA, ThymeLeaf, Bootstrap, MySql.

### O projeto consiste em fazer o controle simples de estacionamento. Registrando entrada e saída dos veículos, calculando o tempo de permanência e realizando as regras de negócio. O sistema também lista os veículos que estão estacionados e os que já saíram.

### Segue abaixo uma breve apresentação das telas da aplicação e de suas funcionalidades:

### A primeira tela será a tela de Login, que pedirá o usuário e a senha:
![telaLogin](https://user-images.githubusercontent.com/94809293/175837466-1b46ed71-6e5c-474f-93e5-47f5842262bc.png)

### Existe a validação do usuário e senha cadastrados no banco de dados e também se os campos estão vazios:
![teleLoginValidacao](https://user-images.githubusercontent.com/94809293/175837656-ad162f47-caea-45cb-9da5-c6cd6f61f1b1.png)

### Após efetuado o login, será mostrada a tela inicial que contém a listagem de todos os veículos que estão estacionados:
![TelaInicial](https://user-images.githubusercontent.com/94809293/175837768-b2a21bbf-3c8e-4fe6-ab5a-347956ee252b.png)

### Na tela inicial pode-se visualizar todos os veículos que estão estacionados, bem como todos os veículos que já saíram:
![listarVeiculos](https://user-images.githubusercontent.com/94809293/175837892-7c227f1c-606e-48c9-8a27-c65baea85256.png)

### Na listagem dos veículos que já saíram, são mostrados todos os dados de entrada e de saída do veículo:
![telaVeiculosSairam](https://user-images.githubusercontent.com/94809293/175838020-9d39d9f2-c407-4f2f-a860-8649a5cc4981.png)

### Ao clicar no botão "Nova entrada" será mostrada a tela para registrar a entrada do veículo no estacionamento. (OBS: Após dar entrada em um veículo, ele passará a aparecer na listagem de veículos estacionados).
![telaEntradaVeiculo](https://user-images.githubusercontent.com/94809293/175838103-79a72188-1d34-4c20-81a4-e49fbeb39271.png)

### Na tela de entrada, não serão aceitos os campos vazios e o campo de placa apenas aceitará os dois tipos vigentes de placas: AAA2222 ou AAA2A22
![telaEndredaVeiculoValidacao](https://user-images.githubusercontent.com/94809293/175838589-c108b4c5-f824-4b23-b9b6-1f0bcc4a51db.png)

### Na tela inicial, ao clicar no botão "Editar" será aberta a tela com os dados do veículo para edição:
![telaEditarVeiculo](https://user-images.githubusercontent.com/94809293/175838253-a7eb19e5-f355-4946-ab92-2d48bac55e2b.png)

### Na tela inicial, ao clicar no botão "saída" para dar saída do veículo, será aberta a tela de saída com os campos preenchidos automaticamente pela aplicação, informando a data e a hora da saída, a quantidade de horas de permanência e o valor a pagar. (A primeira hora custa R$6,00 e as horas adicionais custam R$4,00). Os valores para cálculo estão registrados no banco de dados.
![telaSaidaVeiculo](https://user-images.githubusercontent.com/94809293/175838423-55857a15-7353-44f5-8932-a4a159683a9c.png)
### OBS: Ao dar saída do veículo, ele não mais será visualizado na lista de veículos estacionados, e sim na de veículos que já saíram.






 
