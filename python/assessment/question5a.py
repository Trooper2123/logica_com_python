import pandas

def ler_csv():
    data = pandas.read_csv("Assessment_PIBs - modelo 1.csv")
    return data

def capturar_dados(data):
    validador = False

    while not validador:
        try:
            pais = input('Informe um país: ')
            ano = input('Informe um ano: ')

            if (len(data.loc[data['País'] == pais]) == 0):
                print('\nPaís não disponível! Digite outro país.\n')
            elif not (ano in data.columns):
                print('\nAno não disponível! Digite outro ano.\n')
            else:
                validador = True
        except:
            print('\nValores Inválidos! Digite novamente os valores corretos.\n')

    Dados = []
    Dados.append(pais)
    Dados.append(ano)

    return Dados


def imprimir_resultado(pais, ano):
    index_pais = read_csv.loc[read_csv['País'] == pais].index[0]
    index_ano = read_csv.columns.get_loc(ano)

    print('\nAnálise de PIB')
    print(f'PIB {pais} em {ano}: US$ {read_csv.iloc[index_pais][index_ano]} trilhões.')
    print('\nFim do Programa!\n')


print("PIB's de 2013 a 2020")
print("Paises disponíveis: EUA,China, Japão,Alemanha,Reino Unido,França,Brasil,Itália,Índia,Rússia,Canadá,Coreia do Sul,Espanha,México e Indonésia ")
read_csv = ler_csv()
Dados = capturar_dados(read_csv)
imprimir_resultado(Dados[0], Dados[1])
