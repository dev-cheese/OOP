import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;

public class MokitoTest {



    @Test
    public void name() {
        // mock 생성
        List mockedList = mock(List.class);

        // mock 객체 사용
        mockedList.add("one");
        mockedList.add("two");

        // 검증 하기
        verify(mockedList).add("one");
        verify(mockedList).clear();
    }

    @Test
    public void name2() {
        // interface 뿐 아니라 구체 클래스도 mock으로 만들 수 있다.
        LinkedList mockedList = mock(LinkedList.class);

// stubbing
        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(1)).thenThrow(new RuntimeException());

// 첫 번째 element를 출력한다.
        System.out.println(mockedList.get(0));

// runtime exception이 발생한다.
        System.out.println(mockedList.get(1));

// 999번째 element 얻어오는 부분은 stub되지 않았으므로 null이 출력
        System.out.println(mockedList.get(999));

// stubbing 된 부분이 호출되는지 확인할 수 있긴 하지만 불필요한 일입니다.
// 만일 코드에서 get(0)의 리턴값을 확인하려고 하면, 다른 어딘가에서 테스트가 깨집니다.
// 만일 코드에서 get(0)의 리턴값에 대해 관심이 없다면, stubbing되지 않았어야 합니다. 더 많은 정보를 위해서는 여기를 읽어보세요.
        verify(mockedList).get(0);
    }
}
