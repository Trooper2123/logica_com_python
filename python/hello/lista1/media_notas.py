def ler_nota():
    validador = False
    while not validador
    nota = float(input(("Informe a nota:")))
        if(nota >= 0 and nota <= 10):
            validador = True
            return nota
        else:
            print("Nota deve estar entre 0 e 10")

n = 3
notas = []

for i in range(n):
    nota = ler_nota()
    notas.append(nota)

media_simples = round(sum(notas)/n,2)
 
print(f"A media é: {media_simples}")