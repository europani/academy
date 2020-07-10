CREATE OR REPLACE FUNCTION encrypt_char(
  str VARCHAR2,
  HASH  VARCHAR2)
  RETURN VARCHAR2
IS
  s VARCHAR2(2000);
  p number := ((floor(length(str)/8+0.9))*8);
BEGIN
    dbms_obfuscation_toolkit.DESEncrypt(
    input_string => rpad(str, p),
    key_string => rpad(HASH, 8, '#'),
    encrypted_string => s);
    RETURN s;
end;
/
CREATE OR REPLACE FUNCTION decrypt_char(
  str VARCHAR2,
  HASH  VARCHAR2)
  RETURN VARCHAR2
IS
  s VARCHAR2(2000);
BEGIN
    dbms_obfuscation_toolkit.DESDecrypt(
    input_string => str,
    key_string => rpad(HASH, 8, '#'),
    decrypted_string => s);
    RETURN trim(s);
end;
/
SELECT encrypt_char('11111-1111', 'aaa') FROM dual;
SELECT decrypt_char(encrypt_char('11111-1111', 'aaa'), 'aaa') FROM dual;
select UTL_RAW.CAST_TO_VARCHAR2(decrypt_char(encrypt_char(UTL_RAW.CAST_TO_RAW('ÇÑ±Û aaa'), 'aaa'), 'aaa')) from dual;
  