冒泡排序
for(int i=0;i<a.length-1;i++){
  for(int j=0;j<a.length-1-i;j++){
    if(a[j]>a[j+1]){
      temp=a[j];
      a[j]=a[j+1];
      a[j+1]=temp;
    }
  }
}
