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
##### App을 finish 하였는데도 불구하고 Thread가 계속 돌아가서 Activity가 끝나지 않았다고 생각한 것 같다. thread는 lifecycle이 아니기 때문에 액티비티가 없어진다고 해서 thread가 없어지는건 아니다. 
##### stackoverflow의 내용
##### First, the thread is not lifecycle aware, so when your activity is dismissed the thread continues to run. You must stop it and cancel work in your activity's onPause. 
##### Incase thread continues to run, why onGetListCategoryDone still be call? I didn't call the doDownloadCategoryList so why it's still call? I'm stuck in it. By the way, you said that I must stop and cancel work, what should I do?
##### The Activity code is calling doDownloadCategoryList(). It's one of the things it does in its onCreate(). This causes the thread to run and when it finishes it is sending a Message to a Handler which is bound to the main thread of your app and that in turn calls bindServce(). To fix it, your Activity will need to maintain a reference to the running Thread and stop it when it is exiting. AsyncTask is available for just this purpose, but can cause similar problems if you're not careful. This article may help: po.st/Cei3m2 http://hiqes.com/androids-asynctask-explained/?utm_source=Direct
##### Also note that the Activity being destroyed is not the same as the Application being exited. Android doesn't work like that. The app's process sticks around and is cached and the different components have separate lifecycles.

##### Thread 멈추게 하는 방법
##### Thread에 관해 간단히 얘기하면 thread는 lifecycle이 아니기 때문에 액티비티가 없어진다고 해서 thread가 없어지는건 아니다.
##### Thread를 멈추게 한다기 보다는 Thread의 loop를 돌지 않게끔 하는 방법이 있다.

#####
##### Fragment 띄우는 방법
