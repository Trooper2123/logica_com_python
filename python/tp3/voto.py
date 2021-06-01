#Desenvolva uma função que recebe a idade de uma pessoa e informe se essa pessoa é:
#Eleitor obrigatório (18 anos completos e menos de 70 anos de idade)
#Eleitor facultativo (16 anos completos e menos de 18 anos ou 70 anos de idade ou mais).
#Não tem direito a voto (menor de 16 anos).
#Fluxo de exceção:
#O programa deve verificar se a idade da pessoa é maior do que zero.

def obrig_voto():
    idade =int(input(f"Insira a idade que deseja consultar:"))
    if idade < 16:
        print("Pena, vocë ainda nao pode votar")
    else:
        if 16 <= idade < 18 or idade >= 70:
            print ("Seu voto e opcional, escolha com cuidado!")
        else:
            print("Seu voto e obrigatorio!")


obrig_voto()