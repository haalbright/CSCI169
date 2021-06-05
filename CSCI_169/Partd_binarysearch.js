let numbers = [1,3,5,7,9,11,31];

function binarySearch(array,target){
  let L = 0;
  let R = array.length - 1;
  while(L<R){
    let middle = Math.floor((L+R)/2);
    if (target == array[middle]){ //if target is found
      return middle;
    }
    else if (target < array[middle]){ //if target is less than element
      R = middle - 1; // look at lower half
    }
    else { //if target is greater than element
      L = middle + 1; //look at the upper half
    }
  }
  return false;//search is unsuccessful
}
console.log('Array we are searching: [1, 3, 5, 7, 9, 11, 31]');
console.log('A target of 2 returns: ', binarySearch(numbers,2)); //return false
console.log('A target of 11 returns: ', binarySearch(numbers,11));//return 5
