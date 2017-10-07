# 배열을 복사할 때 유의할 점

#### 배열을 일일이 다 넣어주는 걸로 했더니 복사할 때마다 값을 잘 못 넣어줌, 오류가 생김
#### 두번째와 같이 System.arraycopy 함수를 써야 오류가 생기지 않음

```java
if (isFilled) {
                for (int ver = v; ver >= 1; ver--) {
                    board.board[ver] = board.board[ver - 1];
                    checkif = true;
                }
                board.board[0] = initBlock;
                v++;
            }
```
```java
if (isFilled) {
                for (int ver = v; ver >= 1; ver--) {
                    System.arraycopy(board.board[ver-1], 0, board.board[ver], 0, board.board[ver].length);
                }
                board.board[0] = initBlock;
                v++;
            }
```

### 추가 공부해야 할 부분
##### Activity 끝내는 방법 (Intent를 이용한 Flag에 해법이 있을 듯 함)
##### Thread 멈추게 하는 방법
##### Fragment 띄우는 방법
