let theboard = [
  ["_","_","_","_","_","_","_","_"],
  ["_","_","_","_","_","_","_","_"],
  ["_","_","_","_","_","_","_","_"],
  ["_","_","_","_","_","_","_","_"],
  ["_","_","_","_","_","_","_","_"],
  ["_","_","_","_","_","_","_","_"],
  ["_","_","_","_","_","_","_","_"],
  ["_","_","_","_","_","_","_","_"]
]

function showTheBoard(board){
  for (let i=0; i<8;i++){
    for (let j=0; j<7;j++){
      process.stdout.write("|"+board[i][j]);
    }
    process.stdout.write("|"+board[i][7]+"|\n");
  }
  process.stdout.write("\n");
}
function isSolved(board){
  let queens = 0;
  for (let i=0; i<8;i++){
    if (board[i].includes("1")){
      queens++;
    }
  }
  if (queens == 8){
    return true;
  } //solved, 8 queens are placed
  return false
}
function impossible(board){
  for (let i=0; i<8;i++){
    if ((!board[i].includes('1'))&&(!board[i].includes('_'))){ //if there is a row w/o a queen, then the board can't be solved
      return true;
    }
  }
  return false;
}

function addQueen(board, row, column){
  // straight lines
  for (let i=0; i<8;i++) (board[i][column] = "0"); //mark with 0 so no queen is placed there
  for (let j=0; j<8;j++) (board[row][j] = "0");
  // diagonals
  i = row;
  j = column;
  while (i < 8 && j < 8){
    board[i][j] = "0"
    i++;
    j++;
}
  i = row;
  j = column;
  while (i < 8 && 0 <= j){
    board[i][j] = "0"
    i++;
    j--;
}
  i = row;
  j = column;
  while (0 <= i && j < 8){
    board[i][j] = "0"
    i--;
    j++;
  }
  i = row;
  j = column;
  while (0 <= i && 0 <= j){
    board[i][j] = "0"
    i--;
    j--;
}
  board[row][column] = "1" //add the queen
}
function copyBoard(board){
  let thecopy=[];
  let inner=[];
  for (let i=0; i<8;i++){
    for (let j=0; j<8;j++){
      inner.push(theboard[i][j]);
    }
    thecopy.push(inner);
  }
  return thecopy;
}
function recursivelySolve(startBoard, column){
  if (isSolved(startBoard)){
    console.log("Solution found!\n");
    //showTheBoard(startBoard);
    return true;
}
  if (impossible(startBoard)){
    console.log("no solution\n");
    showTheBoard(startBoard);
    return false;
}
  for (let row=0; row<8;row++){ //test rows 0-7
    if (startBoard[row][column] == "_"){
      let newBoard = copyBoard(startBoard); //create a new board
      addQueen(newBoard, row, column);
      if (recursivelySolve(newBoard, column+1)){//go the next column
          //showTheBoard(newBoard);
          return true;
      }

    }
  }
  return false;
}

recursivelySolve(theboard, 0);
