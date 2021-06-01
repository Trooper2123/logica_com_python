##Desenvolva uma função que calcule a divisão de uma
# conta de consumo (conta de restaurante ou bar),
# em reais, considerando o número de pessoas que estavam consumindo
# e a taxa de serviço que será paga ao garçom.
#Ao usuário do programa serão solicitados o valor total do consumo,
# em reais, o número total de pessoas e o percentual do serviço prestado, entre 0 e 100.
#Fluxo de exceção:
#O programa deve verificar se o número total de pessoas é maior do que zero.
#O programa deve verificar se o percentual do serviço está dentro do intervalo válido, de 0 a 100.
#Caso valores inválidos sejam digitados, deve ser exibida a mensagem de erro “Valor inválido”
# e o programa deve ser interrompido.



def calculo_conta():
    valor_conta = float(input(f"Insira o valor da sua conta:"))
    total_pessoas = int(input(f"Total de pessoas para dividir a conta:"))
    percentual_gorgeta = int(input(f"Insira percentual da taxa de serviço:"))

    if total_pessoas | percentual_gorgeta < 0 or valor_conta <= float(0.0):
        print("Valor invalido")
    else:
        if 0<= percentual_gorgeta <=100:
            percentual_gorgeta = percentual_gorgeta/100
            print(f"Valor para cada um sem taxa de serviço : {valor_conta / total_pessoas}")
            if percentual_gorgeta < 0:
                print(f"Valor para casa um com taxa de serviço: {round((valor_conta * (1+percentual_gorgeta)) / total_pessoas, 2)}")
            else:
                print(f"Valor para casa um com taxa de serviço: {round((valor_conta * 2) / total_pessoas, 2)}")
        else:
             print("Percentual deve estar entre 0 e 100")


calculo_conta()


