valor_conta =float(input(f"Insira o valor da sua conta:"))
total_pessoas = int(input(f"Total de pessoas para dividir a conta:"))

print(f"Valor para cada um sem 10%: {valor_conta/total_pessoas}")
print(f"Valor para casa um com 10%: {round((valor_conta*1.1)/total_pessoas,2)}")