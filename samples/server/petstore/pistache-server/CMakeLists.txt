cmake_minimum_required (VERSION 3.2)

project(server)

set(CMAKE_CXX_FLAGS ${CMAKE_CXX_FLAGS} -std=c++11)

link_directories(/usr/local/lib/)

aux_source_directory(model MODEL_SOURCES)
aux_source_directory(api API_SOURCES)
aux_source_directory(impl API_IMPL_SOURCES)

include_directories(model)
include_directories(api)
include_directories(impl)

file(GLOB MAIN_SOURCES *.cpp)

set(SERVER_SOURCES
${MAIN_SOURCES}
${MODEL_SOURCES}
${API_SOURCES}
${API_IMPL_SOURCES})

add_executable(server
${SERVER_SOURCES})

target_link_libraries(server net)
