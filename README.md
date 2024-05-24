## **\# Observer-Pattern에 대해서 정리**

### **1\. 옵저버 패턴의 개념**

Observer 패턴의 핵심 로직은 객체 간의 일대다 의존성 개념을 중심으로 회전한다. 이는 한 객체의 상태가 변경되면 그에 의존하는 모든 객체들이 자동으로 알림을 받고 업데이트되는 것을 의미한다.

이 패턴은 객체 간의 느슨한 결합을 달성하기 위해 사용되며,  다음은 핵심 로직에 대한 간략한 설명이다:    
**주제(Subject):** 이는 상태를 보유하는 객체이며, 옵저버가 자신을 등록하고 등록 해제할 수 있게 한다. 주제에서 변경이 발생하면 모든 등록된 옵저버에게 알림을 보낸다.    
**옵저버(Observer):** 이는 주제의 상태 변경에 대해 알려지길 원하는 객체이다. 옵저버는 주제에 자신을 등록하고 변경이 발생하면 알림을 받고, 알림을 받으면 옵저버는 새 상태에 따라 자신을 업데이트할 수 있다.    
**구체적인 주제(Concrete Subject):** 이는 주제의 구체적인 구현이며, 상태를 유지하고 변경이 발생하면 옵저버에게 알림을 보낸다.  
**구체적인 옵저버(Concrete Observer):** 이는 옵저버의 구체적인 구현이며, 구체적인 주제에 대한 참조를 유지하고, 옵저버의 업데이트 인터페이스를 구현하며, 주제에 의해 알림을 받으면 자신을 업데이트한다.

제공된 코드 에서의 코어 로직을 설명하자면, UserEvent는 주제, UserEventListener는 옵저버, UserEventListener의 handleUserEvent 메소드는 업데이트 인터페이스이다.

UserEvent가 게시되면, UserEventListener의 handleUserEvent 메소드가 자동으로 호출되어 UserEventListener의 상태를 업데이트한다.