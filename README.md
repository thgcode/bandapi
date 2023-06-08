# BandAPI

## O que é?

Um projeto para divertimento, uma API que simula uma banda através da [API MIDI do Java](https://docs.oracle.com/javase/8/docs/api/javax/sound/midi/package-summary.html). Por enquanto, apenas um instrumento está implementado, a bateria.

## Modo de uso

Existe uma collection do projeto para Insomnia. Para usar, basta importar o arquivo `bandapi-collection.json` e já poderá usar os endpoints disponíveis na API.

## Descrição dos endpoints

### put /api/bateria/v1/batida

Toca uma batida especificada.

Body: objeto com o seguinte formato:

"batidas": {objeto com chave: número da batida
Valor: lista de instruções da batida
Instruções da batida: objeto com {"instrumento": "NOME_DO_INSTRUMENTO", "forca": inteiro com a força da batida, de 1 até 127}."}

Instrumentos disponíveis:

- BUMBO
- CAIXA
- ARO
- CHIMBAL_FECHADO
- CHIMBAL_ABERTO
- PRATO

Exemplo:

```json
{
  "batidas": {
    "1": [{"instrumento": "BUMBO", "forca": 100}],
    "2": [{"instrumento": "CAIXA", "forca": 100}],
    "3": [{"instrumento": "BUMBO", "forca": 100}],
    "3.5": [{"instrumento": "BUMBO", "forca": 100}],
    "4": [{"instrumento": "CAIXA", "forca": 100}],
    "5": [{"instrumento": "BUMBO", "forca": 100}],
    "6": [{"instrumento": "CAIXA", "forca": 100}],
    "7": [{"instrumento": "BUMBO", "forca": 100}],
    "7.5": [{"instrumento": "BUMBO", "forca": 100}],
    "8": [{"instrumento": "CAIXA", "forca": 100}]
  }
}
```

### PUT /api/bateria/v1/bpm

Altera o BPM da bateria.

Body: double contendo o BPM

Exemplo:

```json
130.0
```