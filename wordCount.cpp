#include <iostream>
#include <cstring>
#include <fstream>
#include <cstdio>
#include <cstdlib>

using namespace std;

//linkedlist node
class node{

	string word;
	int frequency;
	node * next = nullptr;
 
public:
	node(string word){
		this->word = word;
		this->frequency = 1;
	}//constructor	

	string getWord(){
		return word;
	}//getWord

	void add(){
		frequency++;
	}//add

	int getFrequency(){
		return frequency;
	}//getFrequency

	void setNext(node * next){
		this->next = next;
	}//setNext

	node * getNext(){
		return next;
	}//getNext
	
	void remove(node *& head){
		if(head != nullptr){
			remove(head->next);
			delete head;
		}//if
	}//remove

};//node

void addToList(node * head, string word){
	//Search threw list for word
	while(head->getNext() != nullptr){
		if(head->getWord() == word){
			head->add();
			return;
		}else{
			head = head->getNext();
		}//if else word is there
	}//while 
	if(head->getWord() == word){
		head->add();
		return;
	}else{
		node * temp = new node(word);
		head->setNext(temp);
	}//if else
}//addToList

void printList(node * head){

	while(head != nullptr){
		cout << head->getFrequency() << " " << head->getWord() << endl;
		head = head->getNext();
	}//while

}//printList



int main(){

	char * buffer = new char[1];
	string word = "";
	node * head = nullptr;
	fstream file;
	file.open("input.txt");
	
	while(!file.eof()){

		file.read(buffer, 1);
		if(*buffer == ' ' || *buffer == '\n' || *buffer == '\0'){
			if(word != ""){
				if(head == nullptr){
					node * temp = new node(word);
					head = temp;
				}else{
					addToList(head, word);
				}//if else for first word
				word = "";				
			}//if
		}else{
			word += *buffer;
		}//if new word else

	}//while not at end of file

	file.close();

	printList(head);	

	head->remove(head);

}//main
