cmake_minimum_required(VERSION 3.4.1)

set(CPP_PATH "${CMAKE_SOURCE_DIR}/src/main/cpp")

include_directories(
                    ${CPP_PATH}/include
                    ${CPP_PATH}/bean
                    ${CPP_PATH}/handle)

add_library(
             imagehandle
             SHARED
             ${CPP_PATH}/native-lib.cpp

              ${CPP_PATH}/bean/Color.cpp

              ${CPP_PATH}/handle/GrayHandle.cpp)


target_link_libraries(
                       imagehandle
                       android
                       log
                       -ljnigraphics )