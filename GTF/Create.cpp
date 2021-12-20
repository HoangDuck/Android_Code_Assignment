#include <stdio.h>
#include <iostream>
using namespace std;

bool check(int A[][6],int x,int y,int n){
	for(int i=0;i<6;i++){
		if(i!=y){
			if(A[x+y][i]==1){
				return false;
			}
		}
	}
	return true;
}
int main(){
	int n=35,i,j;
	int A[100][6]={0};
	for(i=n;i>=0;i--){
		for(j=1;j<6;j++){
			if(i+j<=n)
				if(check(A,i,j,n))
					A[i][j]=1;
		}
	}
	FILE *fo;
	fo = fopen("bpa.txt","wt");
	if (fo == NULL)
	{
		printf("Khong doc duoc file");
		exit(0);
	}
	for (i=0;i<n;i++){
		for (j=1;j<6;j++)
			fprintf(fo,"%d ",A[i][j]);
		fprintf(fo,"\n");
	}
		
	fclose(fo);
}

