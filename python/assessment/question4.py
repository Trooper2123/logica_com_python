import matplotlib.pyplot

aporte = float(input(f"Valor do aporte inicial:"))
rendimento = float(input(f"Rendimento por período:"))
rendimento_r = 1 + (rendimento / 100)
aporte_mensal = float(input(f"Valor do aporte mensal:"))
periodos = int(input(f"Total de períodos:"))
array_periodos = []
array_rendimento = []


def calculo_juros():
    count = 0
    proximo_valor = 0
    while count < periodos:
        if count == 0:
            proximo_valor = round(aporte * rendimento_r + aporte_mensal, 2)
            print(f"Total do 1º periodo: R${proximo_valor}")
        else:
            proximo_valor = round(proximo_valor * rendimento_r + aporte_mensal, 2)
            print(f"Total do {count + 1}º periodo: R${proximo_valor}")

        array_periodos.append(count)
        array_rendimento.append(proximo_valor)
        count = count + 1


calculo_juros()


resposta = input(f"Gostaria de ver o grafico de sua simulação? S/N:")
if resposta == "S":
    matplotlib.pyplot.plot(array_periodos, array_rendimento)
    matplotlib.pyplot.xlabel(' Período')
    matplotlib.pyplot.ylabel('Valor Acumulado')

    matplotlib.pyplot.show()
else:
    print("Programa finalizado")
