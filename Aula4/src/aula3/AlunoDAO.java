/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aula3;

/**
 *
 * @author l
 */
public class AlunoDAO {
    Aluno[] alunos;
    int tamMax, posicao;
    
    public AlunoDAO(){
        alunos = null;
    }
    
    public AlunoDAO(int tam){
        alunos = new Aluno[tam];
        tamMax = tam;
        posicao = 0;
    }
    
    public void adicionar(Aluno aluno){
        if(posicao < tamMax){
            alunos[posicao] = aluno;
            posicao++;
        } else {
            System.out.println("Tamanho do vetor excedido");
        }
    }
    // Overload de adicionar
    public void adicionar(String nome,
            String sobrenome, String 
            matricula, double codCurso,
            int semestre){
        Aluno aluno = new Aluno(nome, sobrenome, matricula,
                        codCurso, semestre);
        this.adicionar(aluno);
    }
    
    public void pesquisar(String nome){
        //String resultado = "";
        for(int i = 0; i < posicao; i++){
            if(nome.equals(this.alunos[i].nome)){
                //resultado += this.aluno[i]...
                System.out.println("Nome: "+this.alunos[i].nome);
                System.out.println("Sobrenome: "+this.alunos[i].sobrenome);
                System.out.println("Mat: "+this.alunos[i].matricula);
                System.out.println("Curso: "+this.alunos[i].codCurso);
                System.out.println("Sem: "+this.alunos[i].semestre);
            }
        }
    }
    // Overload de pesquisar
    public void pesquisar(double codCurso){
        //String resultado = "";
        for(int i = 0; i < posicao; i++){
            if(codCurso == this.alunos[i].codCurso){
                //resultado += this.aluno[i]...
                System.out.println("Nome: "+this.alunos[i].nome);
                System.out.println("Sobrenome: "+this.alunos[i].sobrenome);
                System.out.println("Mat: "+this.alunos[i].matricula);
                System.out.println("Curso: "+this.alunos[i].codCurso);
                System.out.println("Sem: "+this.alunos[i].semestre);
            }
        }    
    }
    
    public void listar(){
        //String resultado = "";
        for(int i = 0, j=1; i < posicao; i++, j++){
            System.out.println("ALUNO "+j);
            System.out.println("Nome: "+this.alunos[i].nome);
            System.out.println("Sobrenome: "+this.alunos[i].sobrenome);
            System.out.println("Mat: "+this.alunos[i].matricula);
            System.out.println("Curso: "+this.alunos[i].codCurso);
            System.out.println("Sem: "+this.alunos[i].semestre);
        }    
    }
    
    public void atualizar(String matricula, String nome, String sobrenome, 
            double codCurso, int semestre){
        //String resultado = "";
        for(int i = 0; i < posicao; i++){
            if(matricula.equals(this.alunos[i].matricula)){
                this.alunos[i].nome = nome;
                this.alunos[i].sobrenome = sobrenome;
                this.alunos[i].codCurso = codCurso;
                this.alunos[i].semestre = semestre;

            }
        }    
    }
    
    public void excluir(String matricula){
        int excluido = posicao;
        for(int i = 0; i < posicao; i++){
            if(matricula.equals(this.alunos[i].matricula)){
                excluido = i;
                this.alunos[i] = this.alunos[i+1];
                posicao--;
            }else if(i > excluido){
                this.alunos[i] = this.alunos[i+1];            
            }
        }        
    }
}
