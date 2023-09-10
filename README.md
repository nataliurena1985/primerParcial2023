# Mi 02

### ingreso por teclado y leo con el teclado a travez de la consola

![](https://res.cloudinary.com/dv6nijgvd/image/upload/v1692925194/Android/jhdbvhq2uoofam0eodct.png)

[LinkecomerceHelados](https://comision-432401.vercel.app/)

#### para clonar el proyecto ejecutar el siguiente codigoi

```
git clone [project url]
```

```javascript
import React from "react";
import ReactDOM from "react-dom";
import "./index.css";
import App from "./App";
import { store } from "./app/store";
import { Provider } from "react-redux";

ReactDOM.render(
  <Provider store={store}>
    <App />
  </Provider>,
  document.getElementById("root")
);
```
