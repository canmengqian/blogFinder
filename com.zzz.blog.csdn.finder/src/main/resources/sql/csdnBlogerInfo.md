updateExecStatusById
===

```sql
UPDATE csdn_bloger_info
SET EXEC_SUBCRIBE_STATUS=#{status} , EXE_DATETIME = CURRENT_TIME
WHERE ID = #{id}
```

deleteWithKey
===

```sql
DELETE FROM csdn_bloger_info WHERE BLOGER_ID=#{id}
```