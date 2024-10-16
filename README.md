## Versiones Utilizadas

- **Java**: 17
- **Spring Boot**: 3.3.4

## Despliegue

La API está desplegada en Railway y puede ser accedida en la siguiente URL:

[https://challenge-eldar.up.railway.app](https://challenge-eldar.up.railway.app)

## Descripción del Challenge

Este proyecto fue desarrollado como parte de un challenge que consta de 5 ejercicios. A continuación se describen las respuestas a los ejercicios  2, 3 y 4:

##

### Ejercicio 2
API Endpoint
Calcular la tasa de una operación de tarjeta de crédito

Ejemplo de solicitud con curl:
```
curl --location 'https://challenge-eldar.up.railway.app/api/cards/calculate-fee' \
--header 'Content-Type: application/json' \
--data '{
  "brand": "VISA",
  "amount": 500
}'
```

### Ejercicio 3 - PL/SQL
La tabla de empleados tiene un total de 107 registros. ¿Cuántos registros imprime la siguiente consulta?

```sql
DECLARE
BEGIN
  CURSOR exp_cur IS
  SELECT first_name FROM employees; 
  TYPE nt_fName IS TABLE OF VARCHAR2(20);
  fname nt_fName;
  OPEN exp_cur;
  FETCH exp_cur BULK COLLECT INTO fname LIMIT 10;
  CLOSE exp_cur;
  FOR idx IN 1.. fname.COUNT LOOP
    DBMS_OUTPUT.PUT_LINE (idx||' '|| fname(idx));
  END LOOP;
END;
```
### Respuesta: La consulta imprime 10 registros.

### Ejercicio 4 - PL/SQL
¿Qué es cierto acerca de la siguiente función?


```sql
CREATE OR REPLACE FUNCTION Get_salary(P_Emp_id NUMBER) RETURN NUMBER AS
  L_salary NUMBER;
BEGIN
  SELECT Salary INTO L_salary FROM Employees WHERE employee_id = P_Emp_id;
  RETURN L_salary;
END Get_salary;
```

### Respuesta: La función compila.
