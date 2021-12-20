#include <stdio.h>
#include <time.h>
#include <stdlib.h>
#include <iostream>
#define input "bpa.txt"
int A[100][100];
using namespace std;
int chonNguoiDiTrc();
void nhapBPA(int A[][100]);
int playGame();
int mayChon(int tong,int daChon);
int CptFirst();
void xuat(int kq);
int PersonFirst();
int main(){
	nhapBPA(A);
	xuat(playGame());
}
void nhapBPA(int A[][100]){
	FILE *fi;
	fi = fopen(input,"rt");
	if (fi == NULL)
	{
		printf("Khong doc duoc file");
		exit(0);
	}
	for (int i=0;i<36;i++)
		for (int j=1;j<6;j++)
		fscanf(fi,"%d",&A[i][j]);
	fclose(fi);
}
int playGame(){
	if(chonNguoiDiTrc())
		return PersonFirst();
	return CptFirst();
}
int CptFirst(){
	int tong=0,tmp,tmp2;
	while(tong<36){
		tmp=mayChon(tong,0);
		cout<<"May chon: "<<tmp<<endl;
		tong+=tmp;
		cout<<"Tong: "<<tong<<endl;
		if(tong>35)
			return 0;
		do{
			cout<<"Ban chon: ";
			cin>>tmp2;
		}
		while(tmp==tmp2);
		tong+=tmp2;
		cout<<"Tong: "<<tong<<endl;
		if(tong>35)
			return 1;
	}
}
int PersonFirst(){
	int tong=0,tmp,tmp2;
	while(tong<36){
		
		cout<<"Ban chon: ";
		cin>>tmp;
		tong+=tmp;
		cout<<"Tong: "<<tong<<endl;
		if(tong>35)
			return 1;
		tmp2=mayChon(tong,tmp);
		cout<<"May chon: "<<tmp2<<"\n";
		tong+=tmp2;
		cout<<"Tong: "<<tong<<endl;
		if(tong>35)
			return 0;
	}
}
int mayChon(int tong,int daChon){
	for(int i=1;i<6;i++)
		if(i!=daChon)
			if(A[tong][i]==1)
				return i;
	for(int i=1;i<6;i++)
		if(i!=daChon)
			return i;
}
int chonNguoiDiTrc(){
	srand((int)time(0));
	int n;
	cout<<"Nhap 0 hoac 1: ";
	cin>>n;
	if((rand() % (1 + 1 - 0))==n)
		return 1;
	return 0;
}
void xuat(int kq){
	if(kq)
		cout<<"Ban thua.";
	else
		cout<<"May thua.";
	system("pause");
}
