function partition(input, p, r){
  let pivot=input[r];
  while (p<r){
    while (input[p]<pivot){
      p++;
    }
    while (input[r]>pivot) {
      r--;
    }
    if (input[p]==input[r]){
      p++;
    }
    else if (p<r){
      let temp=input[p];
      input[p]=input[r];
      input[r]=temp;
    }
  }
  return r;
}

function quicksort(arrInput, p, r){
    if(p<r){
      let j = partition(arrInput, p, r);
      quicksort(arrInput, p, j-1);
      quicksort(arrInput, j+1, r);
    }
}
input = [500, 700, 800, 100, 300, 200, 900, 400, 1000, 600];
console.log("Input before quicksort: " + input);
quicksort(input, 0, 9);
console.log("Input after quicksort: " + input);
