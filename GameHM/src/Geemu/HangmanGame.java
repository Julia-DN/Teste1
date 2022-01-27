package Geemu;

import java.util.Random;
import java.util.Scanner;

public class HangmanGame {
	//time to relearn matrix and strings in 3 day lets gooooooooooooooooooo
			public static void main(String[] args) {
				
				int option=0, exit = 0, select=0,game=1,pick=0;
				String word;
				Scanner kazu = new Scanner(System.in); 
				Scanner say = new Scanner(System.in); 
					
				String info[][] = new String[50][50];//HELLY MESS
				info[0][0] = "omori"; info[0][1] = "something"; info[0][2] = "sister"; info[0][3] = "friendship"; info[0][4] = "memories"; info[0][5] = "dreammer"; ; info[0][6] = "piano" ; info[0][7] = "violin" ; info[0][8] = "toybox" ; info[0][9] = "flowers" ; info[0][10] = "sunny";
				info[1][0] = "celeste";	info[1][1] = "moutain"; info[1][2] = "otherself"; info[1][3] = "anxiety"; info[1][4] = "farewell"; info[1][5] = "transgender";info[1][6] = "reflection"; info[1][7] = "summit"; info[1][8] = "bird"; info[1][9] = "strawberry";info[1][10] = "temple";
				info[2][0] = "undertale"; info[2][1] = "friendship"; info[2][2] = "monsters"; info[2][3] = "underground"; info[2][4] = "love"; info[2][5] = "determination"; info[2][6] = "soul"; info[2][7] = "dust"; info[2][8] = "war"; info[2][9] = "soundtrack"; info[2][10] = "family";
				info[3][0] = "hollowknight"; info[3][1] = "vessel"; info[3][2] = "infection"; info[3][3] = "bugs"; info[3][4] = "soul"; info[3][5] = "abyss"; info[3][6] = "sibling"; info[3][7] = "light"; info[3][8] = "gods"; info[3][9] = "troupe"; info[3][10] = "nightmare";
				info[4][0] = "splatoon"; info[4][1] = "music"; info[4][2] = "shooting"; info[4][3] = "salmon"; info[4][4] = "octopus"; info[4][5] = "squid"; info[4][6] = "calamari"; info[4][7] = "news"; info[4][8] = "war"; info[4][9] = "dj"; info[4][10] = "ink";
				info[5][0] = "terraria";
				String info_copy[][] = new String[50][50];
				
				do {
					System.out.println("	||================================||MENU||================================||"
							+ "\nEscolha um opcao:\n1. Gerenciar Temas\n2. Gerenciar Palavras\n3. Jogar\n4. Sair\n");
					option = kazu.nextInt();
					
				if (option == 4)
				{
				exit = 1;
				System.out.println("\nExiting Program...");
				
				}else if (option == 1) {				//**************GERENCIAMENTO DE TEMAS****************
					for (int i = 0; i < 50; ++i) System.out.println();
					System.out.println("> O que deseja fazer?(Digite o numero)\n1. Cadastrar tema\n2. Excluir tema\n3. Buscar por tema\n");
					select = kazu.nextInt();
					
					if (select == 1) {									//ADICIONAR NOVOS TEMAS
						boolean valid=true;
						for (int i = 0; i < 50; ++i) System.out.println();
						System.out.println("Digite o tema ser cadastrado: ");
						word = say.nextLine();
						word = word.toLowerCase(); word = word.replaceAll("\\s", "");
						
						for (int i = 0; i < 50; ++i) System.out.println();
						for (int i=0;info[i][0]!=null;i++) {// test if theme already exists
							if (word==info[i][0] && valid ==true) 
							{valid=false;System.out.println("Um tema com esse nome ja esta cadastrado!Tente outro tema.");}//if exists locks code from register the input;
							if (info[i+1][0]==null && valid==true) {valid=false;info[i+1][0]=word;//if codes reach last word and no repetition found register it;
							System.out.println("Tema cadastrado com sucesso!");}//then locks codes from say its a repeated word
						}
						

						
						
					}else if (select == 2) {						//EXCLUSAO DE TEMAS
						
						boolean invalid=true;
						for (int i = 0; i < 50; ++i) System.out.println();
						System.out.println("Digite o nome do tema a ser excluido:\n");
						word = say.nextLine();
						word = word.toLowerCase(); word = word.replaceAll("\\s", "");
						
						for (int i = 0; i < 50; ++i) System.out.println();
						for (int i=0;info[i][0]!=null;i++) {//looking for theme
							if (word.equals(info[i][0])) {
								System.out.println("Tema encontrado no sistema!\n");
								invalid = false;
							} 
						}
						
						if (invalid == false) {
						for (int i=0;info[i][0]!=null;i++) {//looking for theme
							if (word.equals(info[i][0])) {
								//System.out.println(info[i][1]);	
								if (info[i][1]!= null) {
								invalid= true; 
								System.out.println("Esse tema nao esta vazio, portanto nao pode ser apagado.");
								}
							}
						}
						
						
						if (invalid == false) {
							
						for (int i=0;info[i][0]!=null;i++) {
							boolean skip = false;
								for (int j=0;info[i][j]!=null;j++){
									if (word.equals(info[i][j])) {skip = true;}
									else if (skip == false && !(word.equals(info[i][j]))) {
										info_copy[i][j]= info[i][j];								
								}else if (skip == true && !(word.equals(info[i][j]))) {
									info_copy[i][j-1]= info[i][j];
							}
						}		
					}
						
						/*for (int i=0;info_copy[i][0]!=null;i++) {
							for (int j=0;info_copy[i][j]!=null;j++) {
								info[i][j] = info_copy[i][j];
								System.out.println(info[i][j]);
							}
						}*/
						
						System.out.println("tema apagado com sucesso!");	
				}
			}else {System.out.println("Esse tema nao foi encontrado\n");}		
						
						
						
					}else if (select == 3) { 								//BUSCA DE TEMAS
						for (int i = 0; i < 50; ++i) System.out.println();
						System.out.println("Digite o nome do tema a ser buscado:\n");
						word = say.nextLine();
						word = word.toLowerCase(); word = word.replaceAll("\\s", "");
						for (int i = 0; i < 50; ++i) System.out.println();
						
						int tema = 0;
						
						for (int i=0;info[i][0]!=null;i++) {//looking for theme
							if (word.equals(info[i][0])) {
								System.out.println("Tema encontrado no sistema!\n");
								tema=1;
							}
						}
						if (tema == 0) {System.out.println("Tema digitado nao encontrado. tente novamente.\n");}
					}else {System.out.println("Opcao invalida.");}
					
			
					System.out.println("Retornando ao MENU...\n\n\n");
					
					//******************************************************************************************************************//
					
				}else if (option == 2) {  			//*****************GERENCIAMNETO DE PALAVRAS*************************
					for (int i = 0; i < 50; ++i) System.out.println();
					System.out.println("> O que deseja fazer?(Digite o numero)\n1. Cadastrar palavra\n2. Excluir palavra\n3. Buscar palavra\n4. Listar palavras\n");
					select = kazu.nextInt();
					
					if (select == 1) {									//CADASTRAR PALAVRA
						
						for (int i = 0; i < 50; ++i) System.out.println();
						System.out.println("Digite o tema: ");
						word = say.nextLine();
						word = word.toLowerCase(); word = word.replaceAll("\\s", "");
						for (int i = 0; i < 50; ++i) System.out.println();
						
						int tema = 0,row= 52;
						
						for (int i=0;info[i][0]!=null;i++) {
							if (word.equals(info[i][0])) {System.out.println("Tema encontrado no sistema!\n");tema=1;row =i;}//looking for theme
						}
						if (tema == 0) {System.out.println("Tema digitado nao encontrado. tente novamente.\n");}
						
						if (tema==1) {
							boolean acess=true;
							System.out.println("Digite o nome da palavra desejada: \n");	
							word = say.nextLine(); word = word.toLowerCase(); word = word.replaceAll("\\s", "");
							for (int i = 0; i < 50; ++i) System.out.println();
							
							for (int j=0;info[row][j]!=null;j++) {//check if word isn't repeated;
								if (word.equals(info[row][j]) && acess == true) {//check for repeated word;
									acess=false; System.out.println("Essa palavra ja existe nesse tema! Digite outra(o) palavra/tema.\n");}
								if (info[row][j+1]==null && acess == true) {
									acess=false;
									info[row][j+1]= word;//saving new word;
									System.out.println("Palavra cadastrada!");
									}
								}
							}

							
					}else if (select == 2) {								//EXLCUIR PALAVRAS
						
						boolean invalid=false;
						int row=0, exist=0;
						String theme;
						
						for (int i = 0; i < 50; ++i) System.out.println();
						System.out.println("Digite o nome do tema onde a palavra se encontra: \n");
						theme = say.nextLine();theme = theme.toLowerCase(); theme = theme.replaceAll("\\s", "");
						for (int i = 0; i < 50; ++i) System.out.println();
						
						for (int i=0;info[i][0]!=null;i++) {//looking for theme
							if (theme.equals(info[i][0])) {
								System.out.println("Tema encontrado no sistema!\n");
								invalid = true;
								row = i;
							} 
						}
						
						if (invalid = true) {
						System.out.println("Digite a palavra que deseja apagar:\n");
						word = say.nextLine();
						word = word.toLowerCase(); word = word.replaceAll("\\s", "");
						for (int i = 0; i < 50; ++i) System.out.println();
						
						for (int i=0;info[i][0]!=null;i++) {
							boolean skip = false;
								for (int j=0;info[i][j]!=null;j++){//it breaks when i do it multiple times and i don't know why 
									if (word.equals(info[i][j]) && row == i) {skip = true; exist = 1;}//AAAAAAAAAAAAAAAAAAAAAHHHHHHHHHH
									else if (skip == false && !(word.equals(info[i][j]))) {//pain :(
										info_copy[i][j]= info[i][j];								
								}else if (skip == true && !(word.equals(info[i][j]))) {
									info_copy[i][j-1]= info[i][j];
							}
						}		
					}
						
						/*for (int i=0;info_copy[i][0]!=null;i++) {
							for (int j=0;info_copy[i][j]!=null;j++) {
								info[i][j] = info_copy[i][j];
								System.out.println(info[i][j]);
							}
						}
						*/
						if (exist == 0 ) {System.out.println("Palavra digitada nao foi encontrada");
						}else if (exist ==1 ) {System.out.println("Palavra removida com sucesso!");}
						
						}else {System.out.println("Tema nao foi encontrado! Tente novamente\n");}
							
						
						} else if (select == 3) {								//BUSCAR PALAVRAS
					System.out.println("Digite o nome da palavra desejada: \n");	
					word = say.nextLine();
					word = word.toLowerCase(); word = word.replaceAll("\\s", "");
					int j=0, i=0;
					for (int l = 0; l < 50; ++l) System.out.println();
					
					for (i=0;info[i][0]!=null;i++) {
						for(j=0;info[i][j]!=null;j++) {	
						if (word.equals(info[i][j])) {
							System.out.println("* Palavra encontrada no tema '"+ info[i][0]+"'!");	
						}
					  }
					}
					
						
					}else if (select == 4) {									//LISTAGEM DE PALAVRAS
						System.out.println("Digite o nome do tema a ser buscado:\n");
						word = say.nextLine();
						
						
						word = word.toLowerCase(); word = word.replaceAll("\\s", "");
						
							int tema = 0;
							for (int i = 0; i < 50; ++i) System.out.println();
							
						for (int i=0;info[i][0]!=null;i++) {
							if (word.equals(info[i][0])) {
								System.out.println("Tema encontrado no sistema!\n");
								tema=1;
							}
						}
						if (tema == 0) {System.out.println("Tema digitado nao encontrado\n");}
						
						if (tema==1) {
						for (int i=0;info[i][0]!=null;i++) {
							if (word.equals(info[i][0])) {//comparison to see if theme exists 
								System.out.println("Palavras encontradas no tema ''"+ word+"''");
								if (info[i][1]==null) {//if position is empty == theme empty
									System.out.println("Nao existem palavras associadas a esse tema");
								}else {
									for (int j=1;info[i][j]!=null;j++) {//print all words on named theme
										System.out.println("* "+info[i][j]);
									}
								}
							}
						}
					}	
					}else {System.out.println("Opcao invalida.");}
					
					
					System.out.println("\n\nRetornando ao MENU...\n\n\n");
				
				}else if (option == 3){					//*********************PLAY HANGMAN TIME!****************************
					do {
						
					System.out.println("Escolha um tema:");
					word = say.nextLine();
					
					word = word.toLowerCase(); word = word.replaceAll("\\s", "");
					for (int i = 0; i < 50; ++i) System.out.println();
					
					int tema = 0, row=0, collum=0;
					
					//procurar por tema
					for (int i=0;info[i][0]!=null;i++) {  
						if (tema==0) {
							row=i;
						if (word.equals(info[i][0])) {
							tema =1;
							for(int j=1;info[i][j]!=null;j++) {collum++;}
							}	
						}
					}
					
					if (tema==1) {
						
						System.out.println("Tema encontrado!\n Iniciando jogo...\n");
						
						int rng,done=0, hp=5;
						String line, guess;
						Scanner chance = new Scanner (System.in);
						Random roll = new Random();
				
						rng = 1+roll.nextInt(collum);
						line = info[row][rng];
						char[] text = line.toCharArray();
						char[] wrong_text = new char[26];
						char[] p_input = new char[text.length];
						System.out.print("\n\n_________" + "\n|        |" + "\n|" + "\n|" + "\n|" + "\n|" + "\n|_______________________\n\n");
						System.out.println("Chances:" + hp+ "\n\n");
						
						for(int i=0; i<text.length;i++) {p_input[i] = '_' ;System.out.print(" "+ p_input[i]);}//asthetic and replacement;
						System.out.println("\n\nPalavra de "+ text.length +" letras");
						boolean over = false;
						
					do {	
						
					int feito=0;
					boolean condition = false;
					System.out.print("\n\nDigite uma letra: \n");
					guess = chance.next();
					guess = guess.toLowerCase();
					for (int i = 0; i < 50; ++i) System.out.println();
						
				for (int i=0; i<text.length; i++)
					{
					if (guess.charAt(0)==text[i]) {//verificando se letra pertence a palavra
						if (guess.charAt(0)==p_input[i]){System.out.println("Tente outra letra!\n\n");feito++;condition = false;}
						else if (feito==0) {
						condition = true;//processo de verificacao do termino do jogo;
						p_input[i]=text[i];
							}
						}
					}
				
				

				if (condition == false) {
				for (int i=0;i<26;i++) { //se letra faz parte da palavra
					if (guess.charAt(0) == wrong_text[i]) {
						if (feito==0) {System.out.println("Tente outra letra!\n\n");feito++;}
						}else if (feito==0){wrong_text[i]=guess.charAt(0);hp--;System.out.println("Letra errada! tente novamente\n\n");feito++;}	
				}
			}
				
				
				if (hp == 5) {System.out.print("\n_________" + "\n|        |" + "\n|" + "\n|" + "\n|" + "\n|" + "\n|_______________________\n");
				
				}else if (hp == 4) {System.out.print("\n_________" + "\n|        |" + "\n|        O" + "\n|" + "\n|" + "\n|" + "\n|_______________________\n");
				
				}else if(hp == 3) {System.out.print("\n_________" + "\n|        |" + "\n         O" + "\n|     ---|" + "\n|" + "\n|" + "\n|_______________________\n");
				
				}else if (hp == 2) {System.out.print("\n_________" + "\n|        |" + "\n|        O" + "\n|     ---|---" + "\n|" + "\n|" + "\n|_______________________\n");
				
				}else if (hp == 1) {System.out.print("\n_________" + "\n|        |" + "\n|        O" + "\n|     ---|---" + "\n|        /" + "\n|       /" + "\n|_______________________\n");
				
				}else if (hp == 0) {System.out.print("\n_________" + "\n|        |" + "\n|        O" + "\n|     ---|---" + "\n|        /\\" + "\n|       /  \\" + "\n|_______________________\n");}
				
				
				System.out.println("Chances:" + hp+ "\n\n");
				
				for(int i=0;i<p_input.length;i++) {
					if (p_input[i]=='_') {System.out.print(" _");
					condition=false;}
					else {System.out.print(" "+ p_input[i]);}
				}
				
				System.out.println("\n");
				if (condition==true) {over=true;}
				
				//System.out.println(hp);
				if (hp<1) {over=true;}
				
				
				} while (over==false);
						
						if (over == true && hp>0) {System.out.println("Parabéns!\nVocê acertou a palavra!\nDeseja jogar novamente?");}
						else if (over == true && hp==0) {System.out.println("Você perdeu! Deseja Deseja jogar novamente?");}
						
						System.out.println("1. Jogar novamente\n2. Retornar ao MENU");
						select = kazu.nextInt();
						if (select==1) {game=1;}
						else if (select==2) {game=0;}
						
					}else{System.out.println("Tema digitado nao encontrado. tente novamente.\n");}
					for (int i = 0; i < 50; ++i) System.out.println();
					}while (game==1);
				}
				}while (exit != 1);
			}
}
