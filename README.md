# 🤖 BotTermo

Bot automatizado para resolver o jogo [Termo.ooo](https://term.ooo/) usando Selenium WebDriver e algoritmos de filtragem inteligente de palavras.

---

## 📋 Descrição

BotTermo é uma aplicação Java que automatiza a resolução do jogo Termo (versão brasileira do Wordle), utilizando:

- Automação com Selenium WebDriver
- Filtragem inteligente de palavras baseada no feedback de cada tentativa
- Algoritmos de eliminação progressiva
- Extração de dados dentro do Shadow DOM

O bot interpreta as cores retornadas pelo jogo:

| Cor   | Significado                     |
|------|----------------------------------|
| 🟩 Verde | Letra correta na posição correta |
| 🟨 Amarelo | Letra correta na posição errada |
| ⬛ Cinza | Letra que não existe na palavra |

---

## 🚀 Tecnologias Utilizadas

| Tecnologia | Função |
|-----------|--------|
| Java 24 | Linguagem principal |
| Selenium WebDriver 4.36.0 | Automação do navegador |
| ChromeDriver | Driver para Chrome |
| Maven | Build / Dependências |
| JUnit 5.13.4 | Testes |
| Selenium Logger 2.4.0 | Logs |

---

## 📁 Estrutura do Projeto
```
bottermo/
├── src/
│ ├── main/
│ │ └── java/dev/alclides/
│ │ ├── Main.java
│ │ ├── MotorTermo.java
│ │ ├── Validator.java
│ │ ├── Filtrador.java
│ │ └── ListarPalavrasParaList.java
│ └── test/
│ └── java/
├── palavras_sem_acentos.txt
├── pom.xml
└── README.md

```
---

## 🔧 Instalação

### Pré-requisitos

- Java 24+
- Maven 3.6+
- Google Chrome instalado
- ChromeDriver (gerenciado automaticamente pelo Selenium)

### Passos

```bash
git clone <url-do-repositorio>
cd bottermo
mvn clean install
Certifique-se de que o arquivo palavras_sem_acentos.txt está na raiz do projeto.
````

### ▶️ Como Executar
Via Maven
bash
Copiar código
```
mvn exec:java -Dexec.mainClass="dev.alclides.Main"
```
Via IDE
Abra o projeto e execute Main.java.

## 🎯 Como Funciona
- Carrega lista de ~6.000 palavras

- Abre o Termo no navegador

- Escolhe uma palavra e envia

- Analisa o feedback via Shadow DOM

- Aplica filtros inteligentes

- Repete até encontrar a solução

### Exemplificação do Algoritmo

```
Tentativa 1 → 6.000 palavras
Tentativa 2 → ~3.421 palavras
Tentativa 3 → ~127 palavras
Tentativa 4 → ~18 palavras
Tentativa 5 → ~1 a 3 palavras
```
## 📦 Classes Principais
Classe	Função
Main.java	Ponto de entrada
MotorTermo.java	Controle das tentativas
Validator.java	Leitura do Shadow DOM
Filtrador.java	Aplicação dos filtros
ListarPalavrasParaList.java	Gerenciamento da lista


### 🔍 Observações Técnicas
#### Shadow DOM
- O Termo utiliza Web Components com Shadow DOM encapsulado — por isso os seletores CSS tradicionais não funcionam. O acesso é feito via JavascriptExecutor.



🤝 Contribuindo
Fork

Branch feature/<nome>

Commit

Pull Request

🐛 Problemas Conhecidos
Problema	Solução
Chrome incompatível	Atualize o navegador
Timeout de carregamento	Aumentar Thread.sleep()
Palavras não encontradas	Nem todas estão no dicionário

📜 Licença
Este projeto é apenas para fins educacionais.

👨‍💻 Autor
alclides
https://github.com/alclides

⚠️ Aviso Legal
Este bot é apenas um estudo técnico de automação web com Selenium.
Não utilize para fins comerciais ou que violem o Termo de Uso do site.

⭐ Se este projeto te ajudou, considere deixar uma estrela no GitHub!