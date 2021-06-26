#Você já deve ter ouvido algum especialista dizer que as pessoas precisam dedicar, no máximo, 30% da sua renda mensal
# à moradia, 20% à educação e 15% ao transporte. Esses valores não devem ser totalmente desprezados, mas não podem
# funcionar como um norte para o orçamento doméstico de todas as famílias.

total_renda =float(input(f"Insira o valor total de sua renda mensal:"))
total_moradia =float(input(f"Insira seus gastos totais mensais com moradia:"))
total_educacao = float(input(f"Insira seus gastos totais mensais com educação:"))
total_transporte = float(input(f"Insira seus gastos totais mensais com transporte:"))



perc_moradia = 0.3
perc_educacao = 0.2
perc_transporte = 0.15


def saude_financeira_moradia():
    if total_moradia > total_renda * perc_moradia:
        perc_real_moradia = (total_moradia * 100)/total_renda
        total_ideal_moradia = total_renda * perc_moradia
        print(f"Seus gastos totais com moradia comprometem {perc_real_moradia}% de"
              " sua renda total. O máximo recomendado é de 30%. Portanto, "
              f"idealmente, o máximo de sua renda comprometida com moradia deveria ser de R$ {total_ideal_moradia}.")
    else: print("Seus gastos com moradia estão dentro da margem recomendada.")



def saude_financeira_transporte():
    if total_transporte > total_renda * perc_transporte:
        perc_real_transporte = (total_transporte * 100) / total_renda
        total_ideal_transporte = total_renda * perc_transporte
        print(f"Seus gastos totais com moradia comprometem {perc_real_transporte}% de"
              " sua renda total. O máximo recomendado é de 30%. Portanto, "
              f"idealmente, o máximo de sua renda comprometida com moradia deveria ser de R$ {total_ideal_transporte}.")
    else:print("Seus gastos com tranporte estão dentro da margem recomendada.")


def saude_financeira_educacao():
    if total_educacao > total_renda * perc_educacao:
        perc_real_educacao = (total_educacao * 100) / total_renda
        total_ideal_educacao = total_renda * perc_educacao
        print(f"Seus gastos totais com educação comprometem {perc_real_educacao}% de"
              " sua renda total. O máximo recomendado é de 30%. Portanto, "
              f"idealmente, o máximo de sua renda comprometida com moradia deveria ser de R$ {total_ideal_educacao}.")
    else:print("Seus gastos com educação estão dentro da margem recomendada.")


def saude_financeira():
    saude_financeira_moradia()
    saude_financeira_educacao()
    saude_financeira_transporte()



saude_financeira()