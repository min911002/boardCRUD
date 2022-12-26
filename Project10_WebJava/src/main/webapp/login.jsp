<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
                <!-- 로그인 페이지 -->
                <section class="contents">
                    <form action="LoginCtrl.do" method="post">
                        <table class="table">
                            <tr>
                                <td>아이디</td>
                                <td>
                                    <input type="text" name="id">
                                </td>
                            </tr>
                            <tr>
                                <td>비밀번호</td>
                                <td>
                                    <input type="password" name="password">
                                </td>
                            </tr>
                            <tr>
                                <td colspan="2">
                                    <br><br><br>
                                    <input type="submit" value="로그인" class="btn btn-primary"> &nbsp;&nbsp;
                                    <input type="reset" value="취소" class="btn btn-secondary"> &nbsp;&nbsp;
                                    <input type="button" value="회원가입" class="btn btn-success" onclick="location.href='index.jsp?content=member.jsp'">
                                </td>
                            </tr>
                        </table>

                    </form>
                </section>