# 🚗 Sistema de Gerenciamento de Estacionamento

Este projeto foi desenvolvido em Java com o objetivo de praticar lógica de programação, orientação a objetos e controle de fluxo com estruturas simples. A aplicação simula o gerenciamento de um estacionamento, permitindo registrar a entrada e saída de veículos, validar vagas disponíveis e calcular o tempo de permanência e o valor a pagar.

---

## 🛠️ O que foi feito até agora

Durante o desenvolvimento, implementamos as seguintes funcionalidades:

- ✅ **Registro de entrada de veículos**, com coleta de:
  - Tipo do veículo (Carro, Moto, etc.)
  - Nome do condutor
  - Número da vaga
- ✅ **Geração de ticket único (ID)** para cada entrada
- ✅ **Validação de vaga ocupada** para impedir sobreposição
- ✅ **Cálculo de tempo de permanência**
- ✅ **Cálculo do valor a pagar**, baseado em R$ 5,00 por hora
- ✅ **Remoção do veículo após saída**
- ✅ **Listagem de todos os veículos atualmente estacionados**
- ✅ Estrutura organizada com duas classes principais:
  - `Veiculo.java`
  - `EstacionamentoApp.java`

---

## 🧪 Tecnologias e conceitos aplicados

- Java 17+
- `Scanner` (entrada via console)
- `Map` para armazenar os veículos ativos
- `LocalDateTime` e `Duration` para controle de tempo
- Boas práticas com `getters`, `toString()` e validação de entrada
- Git + GitHub para versionamento

---

## 📦 Como executar o projeto

1. Clone o repositório:
   ```bash
   git clone https://github.com/MatheusAlcn/NOME_DO_REPOSITORIO.git
