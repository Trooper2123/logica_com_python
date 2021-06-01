G = 5.68
A = 4.68

select = input("Gostaria de abastecer com oque hj? G para gasolina e A para alcool")
valor = float(input("Insira valor total do abastecimento:"))

if(select == 'G'):
    total = round(valor/G,2)
    print(f"Total de litros de gasolina: {total}")
else:
    total = round(valor/A,2)
    print(f"Total de litros de alcool: {total}")