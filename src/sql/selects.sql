/*1) Buscar os nomes de todos os alunos que frequentam alguma turma do professor 'JOAO PEDRO'.*/
SELECT ALUNO.nome FROM ALUNO 
INNER JOIN TURMA ON (ALUNO.id = TURMA.ALUNO_id)
INNER JOIN PROFESSOR ON (TURMA.PROFESSOR_id = PROFESSOR.id)
WHERE (PROFESSOR.nome = 'JOAO PEDRO')

/*2) Buscar os dias da semana que tenham aulas da disciplina 'MATEMATICA'.*/
SELECT DISTINCT TURMA.dia_da_semana FROM TURMA
INNER JOIN DISCIPLINA ON (TURMA.DISCIPLINA_id = DISCIPLINA.id)
WHERE (DISCIPLINA.nome = 'MATEMATICA')

/*3) Buscar todos os alunos que frequentem aulas de 'MATEMATICA' e também 'FISICA'.*/
SELECT ALUNO.nome FROM ALUNO
INNER JOIN TURMA ON (ALUNO.id = TURMA.ALUNO_id)
INNER JOIN DISCIPLINA ON (TURMA.DISCIPLINA_id = DISCIPLINA.id)
WHERE (DISCIPLINA.nome = 'MATEMATICA') 
AND ALUNO.nome IN
(
  SELECT ALUNO.nome FROM ALUNO
  INNER JOIN TURMA ON (ALUNO.id = TURMA.ALUNO_id)
  INNER JOIN DISCIPLINA ON (TURMA.DISCIPLINA_id = DISCIPLINA.id)
  WHERE (DISCIPLINA.nome = 'FISICA')
)

/*4) Buscar as disciplinas que não tenham nenhuma turma.*/
SELECT DISCIPLINA.nome FROM DISCIPLINA 
LEFT JOIN TURMA ON (DISCIPLINA.id = TURMA.DISCIPLINA_id)
WHERE (TURMA.DISCIPLINA_id = null)

/*5) Buscar os alunos que frequentem aulas de 'MATEMATICA' exceto os que frequentem 'QUIMICA'.*/
SELECT ALUNO.nome FROM ALUNO
INNER JOIN TURMA ON (ALUNO.id = TURMA.ALUNO_id)
INNER JOIN DISCIPLINA ON (TURMA.DISCIPLINA_id = DISCIPLINA.id)
WHERE (DISCIPLINA.nome = 'MATEMATICA') 
AND ALUNO.nome NOT IN
(
  SELECT ALUNO.nome FROM ALUNO
  INNER JOIN TURMA ON (ALUNO.id = TURMA.ALUNO_id)
  INNER JOIN DISCIPLINA ON (TURMA.DISCIPLINA_id = DISCIPLINA.id)
  WHERE (DISCIPLINA.nome = 'QUIMICA')
)
