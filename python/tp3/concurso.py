#Em um concurso de fantasias, os jurados precisam digitar os nomes dos 5 participantes
# e suas respectivas notas, variando de 0 até 10. Crie uma função que leia os nomes dos
# participantes e, ao final, apresente apenas o nome e a nota do vencedor.
#Fluxo de exceção:
#O programa deve verificar se a nota da pessoa é maior ou igual a zero e menor ou igual a dez.

def calcula_vencedor():

    for i in range(5):
        participante = str(input(f"Nome do participante:"))
        nota = float(input(f"Informe a nota do participante {participante}:"))
        if 0 <= nota <= 10:
            if i == 0:
                    nota_vencedor = nota
                    participante_vencedor = participante
            elif nota > nota_vencedor:
                    participante_vencedor = participante
                    nota_vencedor = nota
        else:
            print("Nota deve estar entre 0 e 10")
            quit()

    print(f"Participante vencedor(a):{participante_vencedor}")
    print(f"Nota final {nota_vencedor}")

calcula_vencedor()


