-- 1번.
SELECT student_id, count(*) count_
    FROM student
    WHERE student_name = '조인성' AND student_pw = '1234'
    GROUP BY student_id;

-- 2.
SELECT oc.open_course_id, c.course_name, oc.open_course_start_date start_date, oc.open_course_end_date end_date
    FROM course c, open_course oc, student_history sh
    WHERE c.course_id = oc.course_id
        AND oc.open_course_id = sh.open_course_id
        AND student_id = 'ST00031';
    
-- 3.
SELECT sh.student_id, c.course_name, oc.open_course_start_date start_date, oc.open_course_end_date end_date, cr.class_room_name,
    NVL2((SELECT student_id
            FROM process_complete
            WHERE student_id = 'ST00031'
                AND open_course_id = 'OC0001'), '중도탈락', CASE
                                                        WHEN TO_CHAR(oc.open_course_end_date, 'YYYY-MM-DD') < TO_CHAR(sysdate, 'YYYY-MM-DD') THEN '수료'
                                                        ELSE '수료예정'
                                                        END) ifComplete, NVL((SELECT dropout_date
                                                                        FROM process_complete
                                                                        WHERE student_id = 'ST00031'
                                                                            AND open_course_id = 'OC0001'), oc.open_course_end_date) completeDate
            FROM course c, open_course oc, class_room cr, student_history sh
            WHERE c.course_id = oc.course_id
                AND oc.class_room_id = cr.class_room_id
                AND oc.open_course_id = sh.open_course_id
                AND sh.student_id = 'ST00031'
                AND oc.open_course_id = 'OC0001';
                
-- 4.
SELECT os.open_subject_id, sub.subject_name, TO_CHAR(os.subject_start_date, 'YYYY-MM-DD') start_date, TO_CHAR(os.subject_end_date, 'YYYY-MM-DD') end_date
    FROM open_subject os, subject sub
    WHERE os.subject_id = sub.subject_id
        AND os.open_course_id = 'OC0001';    
        
-- 5.
SELECT sub.subject_name, TO_CHAR(os.subject_start_date, 'YYYY-MM-DD') start_date, TO_CHAR(os.subject_end_date, 'YYYY-MM-DD') end_date, sb.subjectbook_name, ins.instructor_name, 
        sp.attendance_point, sp.write_point, sp.skill_point, ss.attendance_score, ss.write_score, ss.skill_score, TO_CHAR(ex.exam_date, 'YYYY-MM-DD') exam_date, ex.exam_file
    FROM open_subject os, subject sub, subjectbook sb, instructor ins, exam ex, subject_point sp, student_score ss
    WHERE os.subject_id = sub.subject_id
        AND os.subjectbook_id = sb.subjectbook_id
        AND os.instructor_id = ins.instructor_id
        AND os.open_subject_id = ex.open_subject_id
        AND ex.exam_id = sp.exam_id
        AND ex.exam_id = ss.exam_id(+)
        AND os.open_subject_id = 'OS0032'
        AND ss.student_id(+) = 'ST00031';
        
-- 6.
SELECT student_name, student_phone
    FROM student
    WHERE student_id = 'ST00031';
    
-- 7.
SELECT sh.student_id, c.course_name, TO_CHAR(oc.open_course_start_date, 'YYYY-MM-DD') start_date, TO_CHAR(oc.open_course_end_date, 'YYYY-MM-DD') end_date, cr.class_room_name,
        CASE
            WHEN pc.student_id = 'ST00031' AND pc.open_course_id = oc.open_course_id THEN '중도탈락'
            WHEN TO_CHAR(oc.open_course_end_date, 'YYYY-MM-DD') < TO_CHAR(sysdate, 'YYYY-MM-DD') THEN '수료'
            ELSE '수료예정'
        END ifComplete, 
        CASE
            WHEN pc.student_id = 'ST00031' AND pc.open_course_id = oc.open_course_id THEN pc.dropout_date
            ELSE oc.open_course_end_date
        END completeDate
    FROM course c, open_course oc, class_room cr, student_history sh, process_complete pc
    WHERE c.course_id = oc.course_id
        AND oc.class_room_id = cr.class_room_id
        AND oc.open_course_id = sh.open_course_id
        AND pc.student_id = 'ST00031'
        AND sh.student_id = 'ST00031';

-- 8.     
UPDATE student 
    SET student_pw = '1111'
    WHERE student_id = 'ST00031' AND student_pw = '1234';